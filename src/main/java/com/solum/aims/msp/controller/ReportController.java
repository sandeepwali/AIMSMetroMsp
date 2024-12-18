package com.solum.aims.msp.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.solum.aims.msp.comstant.Constants;
import com.solum.aims.msp.controller.parameter.report.DepartmentParam;
import com.solum.aims.msp.controller.parameter.report.ErrorGwParam;
import com.solum.aims.msp.controller.parameter.report.ErrorListParam;
import com.solum.aims.msp.controller.parameter.report.ErrorParam;
import com.solum.aims.msp.controller.parameter.report.GwListParam;
import com.solum.aims.msp.controller.parameter.report.GwParam;
import com.solum.aims.msp.controller.parameter.report.ProductInfoListParam;
import com.solum.aims.msp.controller.parameter.report.ProductInfoParam;
import com.solum.aims.msp.persistence.core.entity.CoreEndDevice.EndDeviceType;
import com.solum.aims.msp.persistence.core.entity.Station;
import com.solum.aims.msp.persistence.entity.Article;
import com.solum.aims.msp.service.AccesspointService;
import com.solum.aims.msp.service.ArticleService;
import com.solum.aims.msp.service.CoreEndDeviceService;
import com.solum.aims.msp.service.StationService;
import com.solum.aims.msp.util.ESLPdfDoc;
import com.solum.aims.msp.util.EndDeviceUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

@RequestMapping(value = { "/report" })
public class ReportController {
	@Autowired
	private ArticleService<Article> articleService;

	@Autowired
	private AccesspointService accesspointService;
	@Autowired
	private StationService stationService;
	@Autowired
	private CoreEndDeviceService coreEnddeviceService;
	@Autowired
	private ESLPdfDoc eslPdfDoc;

	@GetMapping("/dept-list")
	public ResponseEntity<DepartmentParam> getDeptList(@RequestParam(required = false) String company,
			@RequestParam(required = false) String store) {
		try {
			DepartmentParam response = new DepartmentParam();

			List<String> deptList = articleService.getReservedList(store, "F5");
			response.setDeptList(deptList);
			response.setResponseCode(Constants.OK);
			response.setResponseMessage("The request has been completed");

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("X-total-count", String.valueOf(deptList.size()));

			if (deptList.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			return ResponseEntity.ok().headers(header).body(response);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@GetMapping("/error-list")
	public ResponseEntity<ErrorParam> getErrorList(@RequestParam(required = false) String company,
			@RequestParam(required = false) String store, @RequestParam(required = false) String dept,
			@PageableDefault(page = 0, size = 20, sort = "reserved_two", direction = Direction.ASC) Pageable pageable) {
		return getErrorLists("", store, dept, pageable);
	}

	@PostMapping("/error-list-pdf")
	public ResponseEntity<ErrorParam> getErrorListPdf(HttpServletResponse response,
			@RequestParam(required = false) String company, @RequestParam(required = false) String store,
			@RequestParam(required = false) String dept, @RequestParam(required = false) String lang,
			@RequestBody(required = false) Map<String, Object> pdflang,
			@PageableDefault(page = 0, size = 1000000000, sort = "reserved_two", direction = Direction.DESC) Pageable pageable) {
		return getErrorListsAllDeptPdf("", response, store, dept, lang, pdflang, pageable);
	}

	@GetMapping("/error-list-info")
	public ResponseEntity<ErrorParam> getErrorListInfo(@RequestParam(required = false) String company,
			@RequestParam(required = false) String store, @RequestParam(required = false) String dept,
			@PageableDefault(page = 0, size = 20, sort = "reserved_two", direction = Direction.ASC) Pageable pageable) {
		return getErrorLists("INFO", store, dept, pageable);
	}

	@PostMapping("/error-list-info-pdf")
	public ResponseEntity<ErrorParam> getErrorListInfoPdf(HttpServletResponse response,
			@RequestParam(required = false) String company, @RequestParam(required = false) String store,
			@RequestParam(required = false) String dept, @RequestParam(required = false) String lang,
			@RequestBody(required = false) Map<String, Object> langPdf,
			@PageableDefault(page = 0, size = 1000000000, sort = "reserved_two", direction = Direction.DESC) Pageable pageable) {
		return getErrorListsAllDeptPdf("INFO", response, store, dept, lang, langPdf, pageable);
	}

	@GetMapping("/gw-list")
	public ResponseEntity<GwListParam> getGwList(@RequestParam(required = false) String company,
			@RequestParam(required = false) String store,
			@PageableDefault(page = 0, size = 20, sort = "code", direction = Direction.ASC) Pageable pageable) {
		try {
			GwListParam response = new GwListParam();
			List<GwParam> gwList = new ArrayList<>();
			List<Object[]> tempGwList = accesspointService.getGwList(store);

			for (Object[] tempGw : tempGwList) {
				GwParam gw = new GwParam();
				gw.setId(tempGw[0].toString());
				gw.setName(tempGw[1].toString());
				gwList.add(gw);
			}

			response.setGwList(gwList);
			response.setResponseCode(Constants.OK);
			response.setResponseMessage("The request has been completed");

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("X-total-count", String.valueOf(gwList.size()));

			if (gwList.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}
			return ResponseEntity.ok().headers(header).body(response);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@GetMapping("/error-list-gw")
	public ResponseEntity<ErrorGwParam> getErrorListGw(@RequestParam(required = false) String company,
			@RequestParam(required = false) String store, @RequestParam(required = false) String gw,
			@PageableDefault(page = 0, size = 20, sort = "reserved_two", direction = Direction.ASC) Pageable pageable) {
		try {
			pageable = switchPageable(pageable);

			ErrorGwParam responseParam = new ErrorGwParam();
			List<Object[]> data = getGatewayErrorList(gw, pageable);

			if (data == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}
			final int start = (int) pageable.getOffset();
			final int end = Math.min((start + pageable.getPageSize()), data.size());
			final Page<Object[]> tempErrorList = new PageImpl<>(data.subList(start, end), pageable, data.size());
			List<ErrorListParam> errorList = convertErrorListParam(tempErrorList.getContent());

			responseParam.setLastUpdatedTime(getServerTime());
			responseParam.setErrorListGw(errorList);
			responseParam.setResponseCode(Constants.OK);
			responseParam.setResponseMessage("The request has been completed");

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("X-size", String.valueOf(tempErrorList.getSize()));
			header.set("X-totalElements", String.valueOf(tempErrorList.getTotalElements()));
			header.set("X-totalPages", String.valueOf(tempErrorList.getTotalPages()));
			header.set("X-number", String.valueOf(tempErrorList.getNumber()));
			header.set("X-total-count", String.valueOf(errorList.size()));

			if (errorList.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			return ResponseEntity.ok().headers(header).body(responseParam);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@PostMapping("/error-list-gw-pdf")
	public ResponseEntity<ErrorGwParam> getErrorListGwPdf(HttpServletResponse response,
			@RequestParam(required = false) String company, @RequestParam(required = false) String store,
			@RequestParam(required = false) String gw, @RequestParam(required = false) String lang,
			@RequestBody(required = false) Map<String, Object> langPdf,
			@PageableDefault(page = 0, size = 1000000000, sort = "reserved_two", direction = Direction.ASC) Pageable pageable) {
		try {
			pageable = switchPageable(pageable);
			List<Object[]> tempErrorList = getGatewayErrorList(gw, pageable);
			if (tempErrorList == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}
			String gwName = "";
			if (!(ObjectUtils.isEmpty(gw))) {
				gwName = accesspointService.findNameById(gw);
			}
			List<Map<String, Object>> errorListGwPdf = new ArrayList<>();
			for (Object[] tempListInfo : tempErrorList) {
				Map<String, Object> temp = new HashMap<>();
				temp.put("gw", gwName == null ? "" : gwName);
				temp.put("item_group", tempListInfo[0] == null ? "" : tempListInfo[0].toString());
				temp.put("item_id", tempListInfo[1] == null ? "" : tempListInfo[1].toString());
				temp.put("description", tempListInfo[2] == null ? "" : tempListInfo[2].toString());
				temp.put("label_id", tempListInfo[3] == null ? "" : tempListInfo[3].toString());
				String price = tempListInfo[4] == null ? "" : tempListInfo[4].toString();
				if (price.length() >= 3) {
					StringBuffer newString = new StringBuffer(price);
					newString.insert(price.length() - 2, ",");
					temp.put("price", newString.toString());

				} else {
					temp.put("price", price);
				}
				temp.put("amount_tag", tempListInfo[5] == null ? "" : tempListInfo[5].toString());
				temp.put("error_code", "");
				errorListGwPdf.add(temp);
			}
			final int start = (int) pageable.getOffset();
			final int end = Math.min((start + pageable.getPageSize()), tempErrorList.size());
			final Page<Object[]> page = new PageImpl<>(tempErrorList.subList(start, end), pageable,
					tempErrorList.size());
			if (page.getSize() == 0) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}
			PDDocument document = createErrorList("GATEWAY", errorListGwPdf, lang, langPdf, store);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=ErrorListGW.pdf");

			ServletOutputStream servletOutputStream = response.getOutputStream();
			document.save(response.getOutputStream());
			servletOutputStream.flush();
			servletOutputStream.close();
			document.close();

			return ResponseEntity.ok().build();
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@GetMapping("/product-info")
	public ResponseEntity<ProductInfoParam> getProductInfo(@RequestParam(required = false) String company,
			@RequestParam(required = false) String store, @RequestParam(required = false) boolean export,
			@PageableDefault(page = 0, size = 10, sort = "total", direction = Direction.ASC) Pageable pageable) {
		try {
			Station station = stationService.getStation(store);
			if (station == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			ProductInfoParam response = new ProductInfoParam();
			List<ProductInfoListParam> productInfoList = new ArrayList<>();

			Page<Object[]> tempProductInfoList = coreEnddeviceService.getProductInfoList(station.getId(), pageable);

			if (tempProductInfoList == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			for (Object[] tempList : tempProductInfoList) {
				ProductInfoListParam temp = new ProductInfoListParam();
				temp.setType(tempList[0] != null ? tempList[0].toString() : "");
				if (tempList[0] != null) {
					EndDeviceType sLableType = EndDeviceUtils.getEndDeviceClassType(tempList[0].toString());
					temp.setSystem(sLableType.getClassType().name());
				}
				temp.setTotal((tempList[1] != null) ? Integer.parseInt(tempList[1].toString()) : 0);
				temp.setYear8more((tempList[2] != null) ? Integer.parseInt(tempList[2].toString()) : 0);
				temp.setYear7((tempList[3] != null) ? Integer.parseInt(tempList[3].toString()) : 0);
				temp.setYear6((tempList[4] != null) ? Integer.parseInt(tempList[4].toString()) : 0);
				temp.setYear5((tempList[5] != null) ? Integer.parseInt(tempList[5].toString()) : 0);
				temp.setYear5less((tempList[6] != null) ? Integer.parseInt(tempList[6].toString()) : 0);
				temp.setUnknown((tempList[7] != null) ? Integer.parseInt(tempList[7].toString()) : 0);
				productInfoList.add(temp);
			}

			response.setLastUpdatedTime(getServerTime());
			response.setProductInfoList(productInfoList);
			response.setResponseCode(Constants.OK);
			response.setResponseMessage("The request has been completed");

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("X-total-count", String.valueOf(tempProductInfoList.getContent().size()));
			header.set("X-size", String.valueOf(tempProductInfoList.getSize()));
			header.set("X-totalElements", String.valueOf(tempProductInfoList.getTotalElements()));
			header.set("X-totalPages", String.valueOf(tempProductInfoList.getTotalPages()));
			header.set("X-number", String.valueOf(tempProductInfoList.getNumber()));

			if (productInfoList.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}
			return ResponseEntity.ok().headers(header).body(response);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	@PostMapping("/product-info-pdf")
	public ResponseEntity<ProductInfoParam> getProductInfoPDF(HttpServletResponse response,
			@RequestParam(required = false) String company, @RequestParam(required = false) String store,
			@RequestParam(required = false) String lang, @RequestBody(required = false) Map<String, Object> langPdf,
			@PageableDefault(page = 0, size = 1000000000, sort = "total", direction = Direction.ASC) Pageable pageable) {
		try {
			Station station = stationService.getStation(store);
			if (station == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			List<Map<String, Object>> errorListProductInfoPdf = new ArrayList<>();

			Page<Object[]> tempProductInfoList = coreEnddeviceService.getProductInfoList(station.getId(), pageable);

			if (tempProductInfoList == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			for (Object[] tempList : tempProductInfoList) {
				Map<String, Object> temp = new HashMap<>();
				if (tempList[0] != null) {
					EndDeviceType sLableType = EndDeviceUtils.getEndDeviceClassType(tempList[0].toString());
					temp.put("system", sLableType.getClassType().name());
				}
				temp.put("tagType", (tempList[0] != null) ? tempList[0].toString() : "");
				temp.put("totalTag", (tempList[1] != null) ? Integer.parseInt(tempList[1].toString()) : 0);
				temp.put("eightYear", (tempList[2] != null) ? Integer.parseInt(tempList[2].toString()) : 0);
				temp.put("sevenYear", (tempList[3] != null) ? Integer.parseInt(tempList[3].toString()) : 0);
				temp.put("sixYear", (tempList[4] != null) ? Integer.parseInt(tempList[4].toString()) : 0);
				temp.put("fiveYear", (tempList[5] != null) ? Integer.parseInt(tempList[5].toString()) : 0);
				temp.put("underFive", (tempList[6] != null) ? Integer.parseInt(tempList[6].toString()) : 0);
				temp.put("unknown", (tempList[7] != null) ? Integer.parseInt(tempList[7].toString()) : 0);
				errorListProductInfoPdf.add(temp);
			}

			if (tempProductInfoList.getSize() == 0) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}
			PDDocument document = createProductInfoPDF(errorListProductInfoPdf, lang, langPdf, store);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=ErrorListProductInfo.pdf");

			ServletOutputStream servletOutputStream = response.getOutputStream();
			document.save(response.getOutputStream());
			servletOutputStream.flush();
			servletOutputStream.close();
			document.close();

			return ResponseEntity.ok().build();
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	private String getServerTime() {
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
		return dayTime.format(new Date(currentTime));
	}

	private Pageable switchPageable(Pageable pageable) {
		try {
			List<Order> orders = new ArrayList<>();
			for (Order order : pageable.getSort()) {
				Order newOrder = switch (order.getProperty().toLowerCase()) {
				case "itemgroup" -> new Order(order.getDirection(), "reserved_two");
				case "itemid" -> new Order(order.getDirection(), "article_id");
				case "description" -> new Order(order.getDirection(), "name");
				case "labelid" -> new Order(order.getDirection(), "e.label_code");
				case "price" -> new Order(order.getDirection(), "reserved_three");
				default -> order;
				};
				orders.add(newOrder);
			}

			return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(orders));
		} catch (Exception e) {
			log.warn("Fail to customize Sort option for ");

			return pageable;
		}
	}

	private ResponseEntity<ErrorParam> getErrorLists(String distinction, String store, String dept, Pageable pageable) {
		try {
			ErrorParam responseParam = new ErrorParam();
			pageable = switchPageable(pageable);

			Station station = stationService.getStation(store);

			if (station == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			List<String> labelList = new ArrayList<>();
			boolean deptPresent = Optional.ofNullable(dept).isPresent() && !dept.trim().isEmpty();
			if (deptPresent) {
				List<String> data = "INFO".equals(distinction)
						? coreEnddeviceService.getErrorLabelListInfo(station.getId())
						: coreEnddeviceService.getErrorLabelList(station.getId());
				labelList.addAll(data);
			} else {
				List<String> data = "INFO".equals(distinction)
						? coreEnddeviceService.getErrorLabelListInfo(station.getId())
						: coreEnddeviceService.getErrorLabelList(station.getId());
				labelList.addAll(data);
			}
			int count = "INFO".equals(distinction) ? coreEnddeviceService.getErrorLabelListInfoForCount(station.getId())
					: coreEnddeviceService.getErrorLabelListForCount(station.getId());
			// Reserved One = F5,Reserved two =F6 Reserved Three =F66
			Page<Object[]> tempErrorList = null;
			tempErrorList = articleService.getErrorList(dept, labelList, "F5", "F6", "F66", count, "", pageable);
			if (labelList != null && labelList.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}
			if (tempErrorList == null || tempErrorList.getTotalElements() == 0) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			List<ErrorListParam> errorList = convertErrorListParam(tempErrorList.getContent());

			responseParam.setLastUpdatedTime(getServerTime());
			responseParam.setErrorList(errorList);
			responseParam.setResponseCode(Constants.OK);
			responseParam.setResponseMessage("The request has been completed");

			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.set("X-size", String.valueOf(tempErrorList.getSize()));
			header.set("X-totalElements", String.valueOf(tempErrorList.getTotalElements()));
			header.set("X-totalPages", String.valueOf(tempErrorList.getTotalPages()));
			header.set("X-number", String.valueOf(tempErrorList.getNumber()));
			header.set("X-total-count", String.valueOf(errorList.size()));

			if (errorList.isEmpty()) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			return ResponseEntity.ok().headers(header).body(responseParam);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}

	public ResponseEntity<ErrorParam> getErrorListsAllDeptPdf(String distinction, HttpServletResponse response,
	        String store, String dept, String lang, Map<String, Object> pdflang, Pageable pageable) {

	    try {
	        // Switch the pageable if needed
	        pageable = switchPageable(pageable);

	        // Get the station
	        Station station = stationService.getStation(store);
	        if (station == null) {
	            return ResponseEntity.noContent().header("X-total-count", "0").build();
	        }

	        // Get the error labels
	        List<String> labelList = getErrorLabelLists(distinction, station.getId());
	        if (labelList == null) {
	            return ResponseEntity.noContent().header("X-total-count", "0").build();
	        }

	        // Get the count based on distinction
	        int count = "INFO".equals(distinction)
	                ? coreEnddeviceService.getErrorLabelListInfoForCount(station.getId())
	                : coreEnddeviceService.getErrorLabelListForCount(station.getId());

	        // Prepare a list of PDDocuments
	        List<PDDocument> pdfDocuments = generatePdfDocuments(dept, labelList, count, pageable, store, distinction, lang, pdflang);

	        // Check if any PDFs were generated
	        if (pdfDocuments.isEmpty()) {
	            return ResponseEntity.noContent().header("X-total-count", "0").build();
	        }

	        // Merge PDFs and return as a response
	        return mergeAndReturnPdf(pdfDocuments, response);

	    } catch (HttpClientErrorException e) {
	        log.error("HttpClientErrorException: {}", e.getMessage(), e);
	        return ResponseEntity.status(e.getStatusCode()).build();
	    } catch (Exception e) {
	        log.error("Exception: {}", e.getMessage(), e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .header("X-Exception-Type", e.getClass().toString())
	                .header("X-Exception-Cause", e.getMessage()).build();
	    }
	}

	private List<PDDocument> generatePdfDocuments(String dept, List<String> labelList, int count, Pageable pageable, 
	        String store, String distinction, String lang, Map<String, Object> pdflang) {
	    List<PDDocument> pdfDocuments = new ArrayList<>();

	    try {
	        // If no department is provided, process all departments
	        if (dept == null) {
	            List<String> allDepartments = articleService.getReservedList(store, "F5");

	            for (String department : allDepartments) {
	                Page<Object[]> tempErrorList = articleService.getErrorList(department, labelList, "F5", "F6", "F66",
	                        count, "pdf", pageable);
	                if (tempErrorList != null && tempErrorList.getSize() > 0) {
	                    List<Map<String, Object>> errorListPdf = convertErrorListParam(department, tempErrorList);
	                    PDDocument departmentPdf = createErrorListAllDept(distinction, errorListPdf, lang, pdflang, store,department);
	                    pdfDocuments.add(departmentPdf);
	                }
	            }
	        } else {
	            // If a specific department is provided, process that one
	            Page<Object[]> tempErrorList = articleService.getErrorList(dept, labelList, "F5", "F6", "F66", count, "pdf", pageable);
	            if (tempErrorList != null && tempErrorList.getSize() > 0) {
	                List<Map<String, Object>> errorListPdf = convertErrorListParam(dept, tempErrorList);
	                PDDocument departmentPdf = createErrorListAllDept(distinction, errorListPdf, lang, pdflang, store,dept);
	                pdfDocuments.add(departmentPdf);
	            }
	        }
	    } catch (Exception e) {
	        log.error("Error generating PDF documents: {}", e.getMessage(), e);
	    }

	    return pdfDocuments;
	}

	
	private ResponseEntity<ErrorParam> mergeAndReturnPdf(List<PDDocument> pdfDocuments, HttpServletResponse response) {
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=ErrorList.pdf");
	    int totalPageCount = 0; 
	    // Create a PDFMergerUtility and output stream to write merged PDF
	    PDFMergerUtility pdfMerger = new PDFMergerUtility();
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

	    try {
	        // Add each PDDocument to the merger
	        for (PDDocument doc : pdfDocuments) {
	            totalPageCount += doc.getNumberOfPages();
	            try (ByteArrayOutputStream docByteArrayOutputStream = new ByteArrayOutputStream()) {
	                doc.save(docByteArrayOutputStream);
	                byte[] docBytes = docByteArrayOutputStream.toByteArray();
	                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(docBytes);
	                pdfMerger.addSource(byteArrayInputStream);
	            } catch (IOException e) {
	                log.error("Error saving PDDocument to ByteArrayOutputStream: {}", e.getMessage(), e);
	            }
	        }

	        // Perform the merge operation and write the merged result to output stream
	        pdfMerger.setDestinationStream(byteArrayOutputStream);
	        pdfMerger.mergeDocuments(null);

	        // Create the merged document from the byte array output stream
	        PDDocument mergedDocument = PDDocument.load(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));

	        // Add page numbers to the merged document
	        eslPdfDoc.addPageNumbersToMergedPDF1(mergedDocument, totalPageCount);

	        // Write the merged PDF to the response output stream
	        try (ServletOutputStream servletOutputStream = response.getOutputStream()) {
	            mergedDocument.save(servletOutputStream);
	            servletOutputStream.flush();
	        }

	        // Close the merged document
	        mergedDocument.close();

	        return ResponseEntity.ok().build();

	    } catch (IOException e) {
	        log.error("Error writing merged document to response: {}", e.getMessage(), e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .header("X-Exception-Type", e.getClass().toString())
	                .header("X-Exception-Cause", e.getMessage()).build();
	    } finally {
	        // Close all PDDocument objects to release resources
	        closeDocuments(pdfDocuments);
	    }
	}

	private void closeDocuments(List<PDDocument> pdfDocuments) {
	    for (PDDocument doc : pdfDocuments) {
	        try {
	            if (doc != null) {
	                doc.close();
	            }
	        } catch (IOException e) {
	            log.error("Error closing PDDocument: {}", e.getMessage(), e);
	        }
	    }
	}

//
	private List<String> getErrorLabelLists(String distinction, long id) {
		return "INFO".equals(distinction) ? coreEnddeviceService.getErrorLabelListInfo(id)
				: coreEnddeviceService.getErrorLabelList(id);
	}

//
	public PDDocument createProductInfoPDF(List<?> productInfoList, String lang, Map<String, Object> pdfLang,
			String store) {
		String nlsLang = (lang == null) ? "EN" : lang;

		PDDocument document = eslPdfDoc.newPDFDoc();
		eslPdfDoc.setDefaultContryFont(nlsLang);
		eslPdfDoc.setFontSize(10);

		try {
			Map<String, Object> guiMap = (Map<String, Object>) pdfLang.get("guiMap");
			Map<String, Object> msgMap = (Map<String, Object>) pdfLang.get("msgMap");

			eslPdfDoc.newPage();
			Map<String, Object> errorListTable = new HashMap<>();

			String[] columnName = { guiMap.get("system").toString(), guiMap.get("type").toString(),
					guiMap.get("total").toString(), "> 8 " + guiMap.get("year").toString(),
					"7 " + guiMap.get("year").toString(), "6 " + guiMap.get("year").toString(),
					"5 " + guiMap.get("year").toString(), "< 5 " + guiMap.get("year").toString(),
					guiMap.get("unknown").toString() };
			errorListTable.put("columnName", columnName);

			String[] columnKeyList = { "system", "tagType", "totalTag", "eightYear", "sevenYear", "sixYear", "fiveYear",
					"underFive", "unknown" };
			errorListTable.put("columnKey", columnKeyList);

			float[] tableWidth = { 12, 16, 10, 10, 10, 10, 10, 10, 12 };
			errorListTable.put("columnWidth", tableWidth);

			errorListTable.put("data", productInfoList);
			errorListTable.put("msgMap", msgMap);
			errorListTable.put("page", 0);

			eslPdfDoc.drawTable(20f, 700f, PDRectangle.A4.getWidth() - 40f, 550f, errorListTable, true);

			msgMap.put("title", guiMap.get("title_productinfo").toString());
			msgMap.put("store_name", guiMap.get("store_name").toString() + " :");
			msgMap.put("MetroStorename", store);

			eslPdfDoc.drawPDFPageHeaderTail(document, true, true, msgMap);
		} catch (Exception e) {
			log.error("Fail createProductInfoPDF Exception : {}", e.getMessage());
		}
		return document;
	}
	
	private ResponseEntity<ErrorParam> getErrorListsPdf(String distinction, HttpServletResponse response, String store,
			String dept, String lang, Map<String, Object> pdflang, Pageable pageable) {
		try {
			pageable = switchPageable(pageable);

			Station station = stationService.getStation(store);
			if (station == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			List<String> labelList = getErrorLabelLists(distinction, station.getId());
			if (labelList == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			int count = "INFO".equals(distinction) ? coreEnddeviceService.getErrorLabelListInfoForCount(station.getId())
					: coreEnddeviceService.getErrorLabelListForCount(station.getId());
			Page<Object[]> tempErrorList = articleService.getErrorList(dept, labelList, "F5", "F6", "F66", count, "pdf",
					pageable);
			if (tempErrorList == null) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			List<Map<String, Object>> errorListPdf = convertErrorListParam(dept, tempErrorList);

			if (tempErrorList.getSize() == 0) {
				return ResponseEntity.noContent().header("X-total-count", "0").build();
			}

			PDDocument document = createErrorList(distinction, errorListPdf, lang, pdflang, store);

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=ErrorList.pdf");

			ServletOutputStream servletOutputStream = response.getOutputStream();
			document.save(response.getOutputStream());
			servletOutputStream.flush();
			servletOutputStream.close();
			document.close();

			return ResponseEntity.ok().build();
		} catch (HttpClientErrorException e) {
			return ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			log.error("Exception : {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.header("X-Exception-Type", e.getClass().toString()).header("X-Exception-Cause", e.getMessage())
					.build();
		}
	}


//
	private PDDocument createErrorList(String distinction, List<?> errorList, String lang, Map<String, Object> pdfLang,
			String store) {
		String nlsLang = (lang == null) ? "EN" : lang;
		String titleKey;
		String objectKey;

		PDDocument document = eslPdfDoc.newPDFDoc();
		eslPdfDoc.setDefaultContryFont(nlsLang);
		eslPdfDoc.setFontSize(10);

		try {
			Map<String, Object> guiMap = (Map<String, Object>) pdfLang.get("guiMap");
			Map<String, Object> msgMap = (Map<String, Object>) pdfLang.get("msgMap");

			switch (distinction) {
			case "INFO" -> {
				titleKey = "title_errorlist_info";
				objectKey = "dept";
			}
			case "GATEWAY" -> {
				titleKey = "title_errorlist_gw";
				objectKey = "gw";
			}
			default -> {
				titleKey = "title_errorlist";
				objectKey = "dept";
			}
			}

			List<List<?>> spliterrorList = divideErrorList(objectKey, errorList);

			int currentPage = 0;
			for (List<?> objects : spliterrorList) {
				eslPdfDoc.newPage();
				Map<String, Object> errorListTable = new HashMap<>();
				String[] columnName = { guiMap.get("item_group").toString(), guiMap.get("item_id").toString(),
						guiMap.get("description").toString(), guiMap.get("tag_id").toString(),
						guiMap.get("price").toString(), guiMap.get("amount_tag").toString(),
						guiMap.get("error_code").toString() };
				errorListTable.put("columnName", columnName);

				String[] columnKeyList = { "item_group", "item_id", "description", "label_id", "price", "amount_tag",
						"error_code" };
				errorListTable.put("columnKey", columnKeyList);

				float[] tableWidth = { 10, 11, 25, 17, 11, 12, 14 };
				errorListTable.put("columnWidth", tableWidth);

				errorListTable.put("data", objects);
				errorListTable.put("msgMap", msgMap);
				errorListTable.put("page", currentPage);

				int createPage = eslPdfDoc.drawTable(20f, 700f, PDRectangle.A4.getWidth() - 40f, 550f, errorListTable,
						true);

				if (!objects.isEmpty()) {
					String objectVal = ((Map<String, Object>) (objects.get(0))).get(objectKey).toString();
					for (int page = currentPage; page < currentPage + createPage; page++) {
						eslPdfDoc.drawString(page, 20f, 715f, guiMap.get(objectKey).toString() + "." + objectVal + " ( "
								+ (page - currentPage + 1) + " / " + createPage + " )", "right");
					}
					currentPage += createPage;
				}
			}
			msgMap.put("title", guiMap.get(titleKey).toString());
			msgMap.put("store_name", guiMap.get("store_name").toString() + " :");
			msgMap.put("MetroStorename", store);

			eslPdfDoc.drawPDFPageHeaderTail(document, true, true, msgMap);
		} catch (Exception e) {
			log.error("Fail {} Exception : {}", e.getStackTrace()[1].getMethodName(), e.getMessage());
		}
		return document;
	}


	private PDDocument createErrorListAllDept(String distinction, List<?> errorList, String lang, Map<String, Object> pdfLang,
			String store,String dept) {
		String nlsLang = (lang == null) ? "EN" : lang;
		String titleKey;
		String objectKey;

		PDDocument document = eslPdfDoc.newPDFDoc();
		eslPdfDoc.setDefaultContryFont(nlsLang);
		eslPdfDoc.setFontSize(10);

		try {
			Map<String, Object> guiMap = (Map<String, Object>) pdfLang.get("guiMap");
			Map<String, Object> msgMap = (Map<String, Object>) pdfLang.get("msgMap");

			switch (distinction) {
			case "INFO" -> {
				titleKey = "title_errorlist_info";
				objectKey = "dept";
			}
			case "GATEWAY" -> {
				titleKey = "title_errorlist_gw";
				objectKey = "gw";
			}
			default -> {
				titleKey = "title_errorlist";
				objectKey = "dept";
			}
			}

			List<List<?>> spliterrorList = divideErrorList(objectKey, errorList);

			int currentPage = 0;
			for (List<?> objects : spliterrorList) {
				eslPdfDoc.newPage();
				Map<String, Object> errorListTable = new HashMap<>();
				String[] columnName = { guiMap.get("item_group").toString(), guiMap.get("item_id").toString(),
						guiMap.get("description").toString(), guiMap.get("tag_id").toString(),
						guiMap.get("price").toString(), guiMap.get("amount_tag").toString(),
						guiMap.get("error_code").toString() };
				errorListTable.put("columnName", columnName);

				String[] columnKeyList = { "item_group", "item_id", "description", "label_id", "price", "amount_tag",
						"error_code" };
				errorListTable.put("columnKey", columnKeyList);

				float[] tableWidth = { 10, 11, 25, 17, 11, 12, 14 };
				errorListTable.put("columnWidth", tableWidth);

				errorListTable.put("data", objects);
				errorListTable.put("msgMap", msgMap);
				errorListTable.put("page", currentPage);

				int createPage = eslPdfDoc.drawTable(20f, 700f, PDRectangle.A4.getWidth() - 40f, 550f, errorListTable,
						true);

				if (!objects.isEmpty()) {
					String objectVal = ((Map<String, Object>) (objects.get(0))).get(objectKey).toString();
					for (int page = currentPage; page < currentPage + createPage; page++) {
						eslPdfDoc.drawString(page, 20f, 715f, guiMap.get(objectKey).toString() + "." + objectVal + " ( "
								+ (page - currentPage + 1) + " / " + createPage + " )", "right");
					}
					currentPage += createPage;
				}else{
					eslPdfDoc.drawString(currentPage, 20f, 715f, guiMap.get(objectKey).toString() + "." + dept + " ( "
							+ 1 + " / " + 1 + " )", "right");
				}
			}
			msgMap.put("title", guiMap.get(titleKey).toString());
			msgMap.put("store_name", guiMap.get("store_name").toString() + " :");
			msgMap.put("MetroStorename", store);

			eslPdfDoc.drawPDFAllDeptPageHeaderTail(document, true, true, msgMap);
		} catch (Exception e) {
			log.error("Fail {} Exception : {}", e.getStackTrace()[1].getMethodName(), e.getMessage());
		}
		return document;
	}
	
//
	private List<List<?>> divideErrorList(String objectKey, List<?> errorList) {
		List<List<?>> spliterrorList = new ArrayList<>();

		List<Map<String, Object>> deptDataList = null;
		if (!errorList.isEmpty()) {
			for (Iterator<Map<String, Object>> itr = (Iterator<Map<String, Object>>) errorList.iterator(); itr
					.hasNext();) {
				Map<String, Object> currentData = itr.next();

				if (deptDataList == null) {
					deptDataList = new ArrayList<>();
					deptDataList.add(currentData);
				} else if (deptDataList.get(0).get(objectKey).equals(currentData.get(objectKey))) {
					deptDataList.add(currentData);
				} else if (!deptDataList.get(0).get(objectKey).equals(currentData.get(objectKey))) {
					spliterrorList.add(deptDataList);
					deptDataList = new ArrayList<>();
					deptDataList.add(currentData);
				}
			}
		} else {
			deptDataList = new ArrayList<>();
		}
		spliterrorList.add(deptDataList);

		return spliterrorList;
	}

//
	private List<ErrorListParam> convertErrorListParam(List<Object[]> errorList) {
		List<ErrorListParam> convErrorList = new ArrayList<>();

		for (Object[] tempList : errorList) {
			ErrorListParam temp = new ErrorListParam();
			if (tempList[0] == null)
				temp.setItemGroup("");
			else
				temp.setItemGroup(tempList[0].toString());
			if (tempList[1] == null)
				temp.setItemId("");
			else
				temp.setItemId(tempList[1].toString());
			if (tempList[2] == null)
				temp.setDescription("");
			else
				temp.setDescription(tempList[2].toString());
			if (tempList[3] == null)
				temp.setLabelId("");
			else
				temp.setLabelId(tempList[3].toString());
			String price = tempList[4] == null ? "" : tempList[4].toString();
			if (price.length() >= 3) {
				StringBuffer newString = new StringBuffer(price);
				newString.insert(price.length() - 2, ",");
				temp.setPrice(newString.toString());

			} else {
				temp.setPrice(price);
			}
			if (tempList[5] == null)
				temp.setAmountLabel("");
			else
				temp.setAmountLabel(tempList[5].toString());
			if (temp.getItemId() != null || temp.getItemId() != "")
				convErrorList.add(temp);
		}
		return convErrorList;
	}

//
	private List<Map<String, Object>> convertErrorListParam(String dept, Page<Object[]> errorList) {
		List<Map<String, Object>> convErrorList = new ArrayList<>();

		for (Object[] tempListInfo : errorList) {
			Map<String, Object> temp = new HashMap<>();
			temp.put("dept", dept == null ? "" : dept);
			temp.put("item_group", tempListInfo[0] == null ? "" : tempListInfo[0].toString());
			temp.put("item_id", tempListInfo[1] == null ? "" : tempListInfo[1].toString());
			temp.put("description", tempListInfo[2] == null ? "" : tempListInfo[2].toString());
			temp.put("label_id", tempListInfo[3] == null ? "" : tempListInfo[3].toString());
			String price = tempListInfo[4] == null ? "" : tempListInfo[4].toString();
			if (price.length() >= 3) {
				StringBuffer newString = new StringBuffer(price);
				newString.insert(price.length() - 2, ",");
				temp.put("price", newString.toString());

			} else {
				temp.put("price", price);
			}
			temp.put("amount_tag", tempListInfo[5] == null ? "" : tempListInfo[5].toString());
			temp.put("error_code", "");
			convErrorList.add(temp);
		}
		return convErrorList;
	}

	private List<Object[]> getGatewayErrorList(String gateway, Pageable pageable) {
		List<String> labelList = new ArrayList<>();

		Object[] errorLabelList = accesspointService.getErrorLabelByGw(gateway);
		if (errorLabelList.length == 0) {
			return null;
		}
		for (Object tempLabel : errorLabelList) {
			ErrorListParam temp = new ErrorListParam();
			temp.setLabelId(tempLabel.toString());
			labelList.add(temp.getLabelId());
		}
		return articleService.getGwErrorList(labelList, "F5", "F6", "F66", pageable);
	}

}