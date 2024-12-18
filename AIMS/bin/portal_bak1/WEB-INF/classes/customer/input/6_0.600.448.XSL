<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>
	<xsl:param name="versionParam" select="'1.0'"/>
	<xsl:template match="articles">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="448px" page-width="600px">
					<fo:region-body/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">

					<fo:block-container position="absolute" overflow="hidden" width="600px" height="64px" top="0px" left="0px">
						<fo:block position="absolute" line-height="1" white-space="pre" font-family="Arial" font-weight="bold" font-size="64pt" color="#FFFFFF" background-color="#FF0000" text-align="center">SOLUM Co., Ltd.</fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden" width="600px" height="72px" top="65px" left="0px">
						<fo:block position="absolute" line-height="1" white-space="pre" font-family="Arial" font-weight="bold" font-size="36pt" color="#000000" background-color="#FFFFFF" wrap-option="wrap" text-align="center"><xsl:value-of select="article[@index=1]/data/ITEM_NAME"/></fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" >
						<fo:block>
							<fo:instream-foreign-object xmlns:svg="http://www.w3.org/2000/svg">
								<svg:svg>
									<svg:line  x1="0px" y1="140px" x2="600px" y2="140px" style="stroke:#000000;fill:none;stroke-width:2"/>
									<svg:line  x1="300px" y1="140px" x2="300px" y2="448px" style="stroke:#000000;fill:none;stroke-width:2"/>
								</svg:svg>
							</fo:instream-foreign-object>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="290px" height="48px" top="170px" left="305px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="48pt" font-weight="bold" color="#FFFFFF" background-color="#000000" text-align="center">S A L E</fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden"  width="299px" height="64px" top="238px" left="301px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="64pt" color="#000000" background-color="#FFFFFF" text-align="center" text-decoration="line-through">$<xsl:value-of select="article[@index=1]/data/LIST_PRICE"/></fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden"  width="299px" height="96px" top="320px" left="301px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-weight="bold"  font-size="96pt" color="#FF0000" background-color="#FFFFFF" text-align="center">$<xsl:value-of select="article[@index=1]/data/SALE_PRICE"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="150px" height="14px" top="430px" left="301px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="left"><xsl:value-of select="article[@index=1]/data/ARTICLE_ID"/></fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden"  width="150px" height="14px" top="430px" left="450px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="right"><xsl:value-of select="article[@index=1]/data/BARCODE"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" >
						<fo:block  top="59px" left="169px" bottom="231px" right="463px">
							<fo:instream-foreign-object xmlns:svg="http://www.w3.org/2000/svg">
							<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
								<image viewBox="5 145 290 300" preserveAspectRatio="none" x="5px" y="145px" width="290px" height= "300px" xlink:href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABRQAAAUUAQMAAACUKAyrAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAGUExURQAAAP///6XZn90AAAAJcEhZcwAALiIAAC4iAari3ZIAABf0SURBVHja7Z09kvO6mYUptcpS1h1MlcNWTeLQXoCrpFmBvQQvwaED1zQzO5wlzE7Me8vBDWcJXAJDBSxqmhR/QQAEoIMfffec4Ov+GiLx8PDF+4K/yu7JqyIjRGTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRmTEiIwYkREjMmJERozIiBEZMSIjRj82Y5lJ9NH/vMoaP0Mz1jKK7NT/zKWtoRmlNmaHx4+dtNHVSGdGOcV+8UPUMSxjI6fYLexctYZlvGU6nRR/D8tYKSgeA/pD0XoJylgqKM6zf9f6DMqYKyg+Zm6udQzJqBgy6kh86C0kY62i6Eb0TgkZklE/rPfKlq+AjKph/bDwoGS8BGQstT6qg/IzIGOhpGiH9Iey9T0gY66kOGfq9OiYfOCMH5k6PYZlVEL4SJBujI2a4qBLj24zHzjjXpceQzLWmavSYMy1IRmOUVcKr5r06FYM8YxnTXoMyVhpKD406dGtYOMZ9QkyHKNuSnHYpc+436fBWGgodgcd42cSjNk/X4Dxzy/AeKaPEMZXiEftuH5PglGfH9NgzHZpMOYaCn29TsNH/bwnDR/188c0fNTPw9PwUR+RSfi40yfIJHzUH1+nkh+1SsLHUyqMGh/1583S8FF//jENH/XncZPJj7qYTMHHjesKSfi4H/9J10ftJDwRH0/JMKp91F93TcNH/fXrNHzU3weQUH7URGUCPurvS0nDR/39PVlK88ddyj7q7zdLw0ftfXuJ+HgWfqbo41XwM0UfB53S9XEcz4d0fdyvfknPx7Wh6fm4NXtMwcdpOF+T9fEs+S01H68SR1PzcdIpVR9no/mQqo976a9p+Si3NC0ft9NjfB/ng/maqI9nxe8p+XhVeJqSj3Od0vRxMZYPafqovXCdiI8L7dL08fQCPi6H8jVJH8+a/6Xi41Xjaio+LnVK0UdhJB9S9HGv/W8aPuptTcNHk/QY20dxIF8T9PG88f8UfLxu+JqCj6JO6fm4GsfSBHkMxijzcb/5h/iMh01jW71FZTRKjwEZZb2vh/E1JqP0ca6zwV/cHuhyYpQ+KrV2TZogQzHqnxoedUqNUTKKpQnyKxCj7DGkvdGfnB6gcWKUPeIjMW2XGqMs+GRp9DMQo6xcywaxLEG+B2LMM/cny8Mxur35pGV0mFQ4Mbq+aKKNT4clgzJm4Rgb15eKtIwOUeLCWDu+H+ExFbFfzoXx5shYh2V0ehfGg9G+YFdO2+X2TpHHVOTi0J99X6Xzu1nciqELY+FYZkrHYujC+EwpDMfoXgpDMT5TCl3Svxuje5kJxNg8x2i/D9wYnyiFDrHswFg/VQqDMT5RCh3ylgPjzbEUhmR8rlw71FE3xifKtcMGOjCWL8BYODIOZw6sB5wb491FpetZAAfG56YUYRifm1I4FNIIjNZL2zM+OaVwKIb2jM8dXbsUGnvG25PlOgRj9TTjl3WPd+slnivX9ovbMz5bCkMwPlsK7UPFifHuoonRNi3YMz5bCkMwupaZidG2BIRjnC7W2C5vzfh0KQzA6FoKZ4y28RyMsQnI+Hy5ts5dLoxPHV2HYHy+XFvXKRfGJ8u1f8by6VJovSOsGQsAo+Wgs2Z8vlxbJ68fkvH5cm1dTG0Zncv1nNFyK4MxZuEYAeXaumDbMrqW6+WtfnbLhmKsAzIiyrVtMbRlLCGMdqtwYHx6SuGbsXD+Dpm5Pi2XtevLtRQub/WzS1+hGIuAjM+fAWhlV6osGSHl2nY7QzFm4RgBZwBa2cW0JSOmFFrmr8r2488fXbf6suvUqi9MKfTOCCiFlhtqyYgphb4ZEaXQcuAFYiwCMuaQUmiZZC0ZMaXQci0/HiOoXFsWbDtGULm2LNhhGJuAjJgzAK1slq4sP42ZUthV1DCMt4CMqCmF3abaMaKmFHZhbceYg6YUdunBjjEDlWu7UhCGMQ/H2KDKtd22WjHCSqFdoQnC2ARkxJVCqxxW2X0YVQr9MZawUmhVr2wZnUqhjNFiY60YcaUwPUbZM+UWg8+KEVeurZKYFSOuXL8Go0VRtWEElmufjKhy7Y2xRjJaRI0lI+RkeCeLDGHDeAOWa5tMW1l9FleubaqqDSOyXKfGKP+27IvF8uZ9IacUNsPPhhFZrl+D0TzV2jAiy7VNobFghJZrT4w1ltF8n9gx4sq1TTG0YEQeXb8Io3nHlc1HkVMKi5plwYgt16/BaLxTLBix5doiuC0YsaXQDyO2FFokW3NGcCm0WFtERuO9Ys4ILoW+GKFlxnwEmjPeXoARXQozi57NP4ktM6/B+GXcs2lfJbgU+mAs4IwX4zWY9lWAy7V5mjBnzF+AET2lMC9bMRlNy78xI3xK4YERPqUw3y/GjDc8o+kYtGHETiky43xrzFjCpxTGhcaGEVyu8YyupVDHaLhjjBlzeLk2DnALRnQpxDO6lhkdo2EyM2Vs8KXQuNBYMKJLIZzRuRTqGA33jCmjh1JoXAwtGOGlEM3oenStZTTu2+xzrqWw1jKardKCcdpF37FZZgj5Y8QJy1h4Ybz86hhzL4yfUEYviIZlgYw/AuMRydj4YaSPGNFHjOgjRr86H1+kzjgdznzPl9QcBTweXRnV868iGR91jOh4/LX6SEZTBYxHjusNMR6DMjIeN8R4pI+iWGf0YjzSR0GMxw0xHhmPohiPetFH+iio4XGhXmTkuBbFca0X9zXjURR91IvjmoyiOK714nUFxqMo+qgXfeS4FsV41IvxyHgURR/1YjwyHkUxHvViPNJHQYzHDTEeX5+x5Lg2lo7xlxfw8d8vMK5/hvvo9Ki9lvEnOOO/7i4Kmnt2LzCu9x4Yz2AfDx4YP8Dj+uSB8QT28cMD4wEcj2cPjHuwj9cXmD/mPhj/YbQOU8adl3nPn4zWYcq498L4O6N1mDIevDD+1mgdpuP69ALHCh8vcFx4fgEfrzxPoRXPU/A8hSDG44YYj/RRFMe1XoxH+iiI8bghxiN9FEUf9WK9ZjyKYjzqxXhkPIri/FEvxiPzo6CG+1ovjpmw8Xh9gX19Tv+aZvPxAteG/VzThF5jbw4vEI9errHvXyD3HF6A8QSu1z7unfkA10If9yCdwfv64wXmFD7uicvBPh5e4F7XffL3DDd+7r1O/57hX+BzXHw8/gqfqeB5ig3x2JU+ilIxdimpmvoqeqRhtQmc72m6PxfTPuu7rYd0GsXHvA+ix89b100+fnln038f6m1AixGPdf9tou0XJHUsbTfTF4w2/a+VGaMfH28Ptu67PL/axY8d7/CxumccS0gMxqpnbFkv7X/fOsavkTHruz/GYywf/nWMnz3jN5jImJsx+rmuMDBWD8ZSYLz1jFlMH4vHPu4Y3yfGy5KxySL4qGbcyRjrtHzcdWAzxj5aI/vY9lpCGN8jMlZZzHFtxlhmMXN40X8TXaFlLAwZjxEZsyxmvTZibLLZNCmOj8ctxn7Csc347pUx1zEOk6N7vHG9yViZMkb0sZy+Vj9WPL51/9cwFll/yBDPx03GfPo2z2R9nNJjsj7O0mO0cb3rvzdXxThLj5F8PPSMuZbxbsR4jMZ4m1JPNB+zDcZqSj0xGWsdYzn7suM4jL8xYXw3Yzz6ZdypGYspPcbz8UvPmM9OBMbJj795DF01YzNLPZF8PD4Y35SM9Sz1RIrHY/trpWG8zVJPPB/1jNX8e9YT9bE0Z/TmY9tt1f5QMBbz74KPM647xlLDOE89MX3UMWYJMBZ6xv+ep8dI58OP7arL7F3F+Pdsfj0+xrj+vwdjoWb8mwWjHx9/2WT8q0U8+hnX/86OZcf4qWL8y+yoMI6PP7eMRx3j1YLRW51pGXOB8WvJaJrDPeWeXMr4r4kxyyLV66nOXI/VmnF3cWP05OP52F4jzLPLnHEvMJrOzTzF40fHmC0ZD0rGIoaPp+NtzXgSGKd5+P/GiMfDN+Ou6aY38tzTaVzwf2L4uJcxnkXGsRj+M05+lDBelYyR5mbfx336ff2X6MfXLWN7S8KMcXphYMdYRj9PIWGcHmZoGXeV8fmegIzTQyEt41sCjE03154zTg/XtIzHyvjcnrd4bNq59m7OOD2k1DK+36KfI5UwLsf1Z50+46WOfj58k3Fxci9ePP61m54pGLsLTGaM3nz8/v0PGsZdx2h2DekYifF4n59sjufjWcP4fp+ftI8Ujx3jUcn4acHo08dMw3iZ34IULR5zLePX/FauaD5uMt5M71XwF4+P+z30jGb3fPj1UctYx74v5Xgvthib2Pf3GDDeo9wnZc8Y9X4zE8bckNHfuC5NGC8mjP58LLsztTrGwpDxGJGxjHwfqSHjuwmjv3isuqsbOsYq8v3hJoy3yPfZGzK+mTDG9HEq2LF87A5Ql4zDGWZLxvfgjN8fmRgzE0Z/41rJ+D4wNmPBjuXjwyUJ43G8LGfIeIzJOBbs5Hx8GxkLM0Z/8Yhj9Odj02WWibFlFhjHSUWseMQx+vaxUDD2qw3v4ywe31vgt5HxTcp4i+vjmrG7od2J0U88dg8td0/cdozVgvE4PpNbx/RxYizb3qvx4YVHLRwYm5j5sXycX3wfGYcHfgbG3XKb4jwjfhnxLm3cvd8fD0Rm3UHO8D6Ae8x6fXucX7z0v9Ud4zCw20dnjkP/dwNGPz7W2b1/s0P3WyO+Mifvuy0jzsPv3Wv8uh3adfCTuL6euTY6dvXjo61ijGtb0cel6KNejEfGoyjGo16Mxx/BRzKaiuN6KTLqxfzIfS2I9XpDjEcyimK91ov7mvEoiHVmQ4xH+iiK41ovxiN9FEUf9eK4ZjyK+qF8FC66i4zVDMujj+Xs1Q4r5bN3Kjz+v2Cs5+8p8Teu60zj6apRYCzn74Xw52P/Vm7V6rKlOQJjPt8Gf/HY38EsVy42LhnrbL4N3nysh7tkZFo3LhmrxQZ687Hq7zZSrE1sXDIWi23w5mORZWLMiQzznpeM2WIbvI3r4S5CqdaNC8YmW2ygLx+H+wilH6rXjQvGvn0ISF/xWGWZOiCHxouCcbh37mtg9HUfaaYOyGK8x1DOmC830JePw+2Y0oDM140Lxmy5gZ58HG9rlWVxWeOcsRY20NO4Hm+ply1WSxrnjOLCnnysxm4usnWtG+eM5dj+1TN6icepG8nAljXOGQthGzz5OHUjWb2sMV/wLts9MU7dHGWfWTfOGcV2T4xTN+uB3UyN0vfE1WK7n3E9w1gvV8s2QM646xl9+HibMa6mkDfZBswYK3FhP4zzblYDu5w1XuIxzjFW6y9kGzBjXG2Dn/w4x1itP5dtQD7HFbbBj4/zbt7WH5FswIwxE7fBz7ied7PTMUreedWstsGLj/W8G3FBeePEWK820AvjTce4bFy/q2m9sBfGatHNRVyTrHFiLFftXuKxWHQjmCBvnBjzRfvn3ZOPy24EE+SNE2O2avfCuOzmTfyErHFkbNbtPhiFbpbJZzms1++dqdcL+6gzIsZiVnHbYJS0+/BR7OayXJF0A0bGct3u4749EUM8QyvbACXjxY+PYjeLHgr5BuTTSYnVwj7iMRe6EU4qSzcgn2AljHgfhV4WyadRNI6M2XoDPTCuMDIdo/AMpGwbPDDWK8ZZ8qkVGzAw3iTb4KFer7qZJ5+bYgMGxkqyDR58rHSMqsaBsZS0exjXxaqbmQ2qxoExX7V/+vBx3c3MBlXjwJhJtsGDj+tu3ubt8saecZ0Tune5oX3847qbadla1dgzrofU98DGj+s/SDAu02oUjT1jKWn/wvt4lnQz9iFj+Jwx5rJ2fDzKNDvUV2xAzyhb+B3vo0w7XfPbxNhI2/HxKFXfXCsbH4zS9l0YH5cXjGWND0Z5e5h4HIwopY2fI2Mhbb+G8XG8qqZqfDBm+sUxjKp43Om2YDcw1irGID4+ZmCqLfjqGSvV0kHi8ZH9VAyfPWOhWjqMj10SVDEcH4wqmwPF4/g6XKl2D8abcuEwPj5e2KTSZ8dYKtvDxOPjjXEqtW+U/1Tvg1A+djqrGtpvENQs5yser5K+PjI3+fJRtmdPjoye4nEn6+vgyOjJx72sr70d2rgrPPkotWynxLlq/+jJR8vQk+alMQ14GtfyIXy1Ah/X4clHeSpUJUh5oI77wlM8XvXOCDro/xqyziijVP730V0/PipGsF2CHFcS1EdVglTE6TDa/Yzrw4Yzgq76P/vx0bUyLzXY6yceVQPYLUH68fG84cxSqjA9eWW8bjizlGq4H7wyZhvOmPx18tfLuN5lEA2rCeujPPKUxzl9gvQyrg9bziylHO19gxcfMelxNNiLj+oDQKcE6cXH85YzC6kPc04eGIdxfd1yZiH1bOjggXFzXEsjVR29vcM+4hGUHscVBfZRFnvq6O0TpA/Gw6YzC2nG+tUbIyo9Dhb7qNe682MuCdKHj+dNZ+bSnQU6eWO8bjozl+5g8eCNMdt0Rv+XSQ+PPeRHWHocVhXax3X06aL3kSA9jOvDtjNzaUd61+jBR8S5x0GdyR7iUX/5wCFBevBRG2CrVv1J8m6fePDxuu3MTPpzaV1r6HG9ilZ99HYu48e1ZXrUR2+3suA+ivGnj97s8a3FaMaNk7WizRvjvG3G+4ibPbZqbcb7uHV11T5B4n08Gzgzaesa4inzcXx9NXBm0talhkMWYVwL8boVva3P8HgEzh6zfnXhfVxG4Fb0tgkS7uPBxJlJm6P86sFHbHrsjIbX6+2bT6wTJNzHs4kzo7ZvsTh5iMeriTOjtq/EHmKM60XEbkfvHu8jdPbYahfFx3kMbkdvlsPrtcGl/rnVBmMcf18zOj22VqPj0eTePNsEGeK5j7Uzg0zuQDvBfbwaOTPI5EaVQ4xxPYtZk+jdo8c1ePbYahfFxykKTaI3y8HxeDBzZpDRCL+CfcSnx2+zwT6a3bpsmSDBPp7NnOl/mt2gewLPw80cGtw2u4/vEGNcj1FrFr17rI8e0uN3GsD6aHgH+PAxs+jN/gFlNLxRdLDbcHz/CcroIz1m2e+RjI3pkx12CRIbj4YB1gfiPgZjY+rPw2/T25xDPSu11Gn277ai5HBLxWF8RKJp9MbZ148EaRq93NdKXV+AsQ1F48e7Aj3vKqpNkMZPgUTy8ZRZnBqKM67tFMnHNhZN02OseGwTpPHYfoX8GCsebRJkLB/PFk+/xvLxw+IhuVg+nixODUUa198umj/VHsvHvXl6jBaPO4uRHS0/5uYfjVav/8v8o9F8PEditBjX2X9EYrTx0eLUULR4fAUf/9P8o7HqjM0VMeZHndKvMzb1OlZ+fIV5T7T5o9U83FyvcDwTi/FqkSAjHl/ncRhzG0bjBPkJZSxMu7U633OJw9geXH/EYSxNu7U6//gFZbyZdmtzHnd3hzLGFBkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxIiNGZMSIjBiRESMyYkRGjMiIERkxegHGe/X/ieDWDTpWxGUAAAAASUVORK5CYII="/>
							</svg>
							</fo:instream-foreign-object>
						</fo:block>
					</fo:block-container>

				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>
