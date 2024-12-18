package com.solum.aims.msp.util;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;

@Setter @Getter
public class TagType implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int width;
	private int height;

	public enum TemplateSize {
		T0_97("0.97\" (184x88)", 184, 88),
		T1_3("1.3\" (200x144)", 200, 144),
		T1_3_Vertical("1.3\" (144x200)", 144, 200),
		T1_6("1.6\" (152x152)", 152, 152),
		T1_6_4C("1.6\" (168x168)", 168, 168),
		T1_54_4C_1_6_HD("1.54\"/1.6\" (200x200)", 200, 200),
		T2_2("2.2\" (212x104)", 212, 104),
		T2_15_4C_2_2_HD("2.15\"/2.2\" (296x160)", 296, 160),
		T2_2_130dpi("2.2\" (250x122)", 250, 122),
		T2_4("2.4\" (296x168)", 296, 168),
		T2_6("2.6\" (296x152)", 296, 152),
		T2_6_Vertical("2.6\" (152x296)", 152, 296),
		T2_6_HD_2_66_4C("2.6\"/2.66\" (360x184)", 360, 184),
		T2_7("2.7\" (264x176)", 264, 176),
		T2_7_3_3("2.7\"/3.3\" (300x200)", 300, 200),
		T2_9("2.9\" (296x128)", 296, 128),
		T2_9_HD("2.9\" (384x168)", 384, 168),
		T3_0("3.0\" (400x168)", 400, 168),
		T3_52("3.52\" (384x180)", 384, 180),
		T3_7("3.7\" (240x416)", 240, 416),
		T4_2("4.2\" (400x300)", 400, 300),
		T4_3("4.3\" (522x152)", 522, 152),
		T4_3_Vertical("4.3\" (152x522)", 152, 522),
		T4_4("4.4\" (512x368)", 512, 368),
		T5_7("5.7\" (600x200)", 600, 200),
		T5_79_4C_5_85("5.79\"/5.85\" (792x272)", 792, 272),
		T6_0("6.0\" (600x448)", 600, 448),
		T6_0_HD("6.0\" (1024x758)", 1024, 758),
		T6_0_NEW("6.0\" (648x480)", 648, 480),
		T7_3_7_4_7_5("7.3\"/7.4\"/7.5\" (480x800)", 480, 800),
		T7_5("7.5\" (384x640)", 384, 640),
		T7_5_HD("7.5\" (528x880)", 528, 880),
		T8_2("8.2\" (576x1024)", 576, 1024),
		T9_7("9.7\" (672x960)", 672, 960),
		T11_6("11.6\" (640x960)", 640, 960),
		T12_2("12.2\" (768x960)", 768, 960),
		T13_3("13.3\" (1200x1600)", 1200, 1600);
		
		@Getter
		private String name;

		@Getter
		private int width;
		
		@Getter
		private int height;

		TemplateSize(String name, int width, int height) {
			this.name = name;
			this.width = width;
			this.height = height;
		}
		
		public static TemplateSize getType(int width, int height) {
			return Arrays.stream(values())
						.filter(a -> a.width==width)
						.filter(b -> b.height==height)
						.findFirst()
						.orElse(null);
		}
	}
}
