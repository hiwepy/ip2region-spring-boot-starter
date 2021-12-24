/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.hiwepy.ip2region.spring.boot.ext;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Region 国家地区枚举
 * http://doc.chacuo.net/iso-3166-1
 * https://en.wikipedia.org/wiki/ISO_3166-1
 */
public enum RegionEnum {

	AD("020", "AD ", "AND", "ISO 3166-2:AD", "Andorra", "安道尔 "),
	AE("784", "AE", "ARE", "ISO 3166-2:AE", "United Arab Emirates", "阿联酋"),
	AF("004", "AF", "AFG", "ISO 3166-2:AF", "Afghanistan", "阿富汗"),
	AG("028", "AG", "ATG", "ISO 3166-2:AG", "Antigua & Barbuda", "安提瓜和巴布达"),
	AI("660", "AI", "AIA", "ISO 3166-2:AI", "Anguilla", "安圭拉"),
	AL("008", "AL", "ALB", "ISO 3166-2:AL", "Albania", "阿尔巴尼亚"),
	AM("051", "AM", "ARM", "ISO 3166-2:AM", "Armenia", "亚美尼亚"),
	AO("024", "AO", "AGO", "ISO 3166-2:AO", "Angola", "安哥拉"),
	AQ("010", "AQ", "ATA", "ISO 3166-2:AQ", "Antarctica", "南极洲"),
	AR("032", "AR", "ARG", "ISO 3166-2:AR", "Argentina", "阿根廷"),
	AS("016", "AS", "ASM", "ISO 3166-2:AS", "American Samoa", "美属萨摩亚"),
	AT("040", "AT", "AUT", "ISO 3166-2:AT", "Austria", "奥地利"),
	AU("036", "AU", "AUS", "ISO 3166-2:AU", "Australia", "澳大利亚"),
	AW("533", "AW", "ABW", "ISO 3166-2:AW", "Aruba", "阿鲁巴"),
	AX("248", "AX", "ALA", "ISO 3166-2:AX", "?aland Island", "奥兰群岛"),
	AZ("031", "AZ", "AZE", "ISO 3166-2:AZ", "Azerbaijan", "阿塞拜疆"),
	BA("070", "BA", "BIH", "ISO 3166-2:BA", "Bosnia & Herzegovina", "波黑"),
	BB("052", "BB", "BRB", "ISO 3166-2:BB", "Barbados", "巴巴多斯"),
	BD("050", "BD", "BGD", "ISO 3166-2:BD", "Bangladesh", "孟加拉"),
	BE("056", "BE", "BEL", "ISO 3166-2:BE", "Belgium", "比利时"),
	BF("854", "BF", "BFA", "ISO 3166-2:BF", "Burkina", "布基纳法索"),
	BG("100", "BG", "BGR", "ISO 3166-2:BG", "Bulgaria", "保加利亚"),
	BH("048", "BH", "BHR", "ISO 3166-2:BH", "Bahrain", "巴林"),
	BI("108", "BI", "BDI", "ISO 3166-2:BI", "Burundi", "布隆迪"),
	BJ("204", "BJ", "BEN", "ISO 3166-2:BJ", "Benin", "贝宁"),
	BL("652", "BL", "BLM", "ISO 3166-2:BL", "Saint Barthélemy", "圣巴泰勒米"),
	BM("060", "BM", "BMU", "ISO 3166-2:BM", "Bermuda", "百慕大"),
	BN("096", "BN", "BRN", "ISO 3166-2:BN", "Brunei", "文莱"),
	BO("068", "BO", "BOL", "ISO 3166-2:BO", "Bolivia", "玻利维亚"),
	BQ("535", "BQ", "BES", "ISO 3166-2:BQ", "Caribbean Netherlands", "荷兰加勒比区"),
	BR("076", "BR", "BRA", "ISO 3166-2:BR", "Brazil", "巴西"),
	BS("044", "BS", "BHS", "ISO 3166-2:BS", "The Bahamas", "巴哈马"),
	BT("064", "BT", "BTN", "ISO 3166-2:BT", "Bhutan", "不丹"),
	BV("074", "BV", "BVT", "ISO 3166-2:BV", "Bouvet Island", "布韦岛"),
	BW("072", "BW", "BWA", "ISO 3166-2:BW", "Botswana", "博茨瓦纳"),
	BY("112", "BY", "BLR", "ISO 3166-2:BY", "Belarus", "白俄罗斯"),
	BZ("084", "BZ", "BLZ", "ISO 3166-2:BZ", "Belize", "伯利兹"),
	CA("124", "CA", "CAN", "ISO 3166-2:CA", "Canada", "加拿大"),
	CC("166", "CC", "CCK", "ISO 3166-2:CC", "Cocos (Keeling) Islands", "科科斯群岛"),
	CD("180", "CD", "COD", "ISO 3166-2:CD", "Democratic Republic of the Congo", "刚果金"),
	CF("140", "CF", "CAF", "ISO 3166-2:CF", "Central African Republic", "中非"),
	CG("178", "CG", "COG", "ISO 3166-2:CG", "Republic of the Congo", "刚果布"),
	CH("756", "CH", "CHE", "ISO 3166-2:CH", "Switzerland", "瑞士"),
	CI("384", "CI", "CIV", "ISO 3166-2:CI", "C?te d'Ivoire", "科特迪瓦"),
	CK("184", "CK", "COK", "ISO 3166-2:CK", "Cook Islands", "库克群岛"),
	CL("152", "CL", "CHL", "ISO 3166-2:CL", "Chile", "智利"),
	CM("120", "CM", "CMR", "ISO 3166-2:CM", "Cameroon", "喀麦隆"),
	CN("156", "CN", "CHN", "ISO 3166-2:CN", "China", "中国"),
	CO("170", "CO", "COL", "ISO 3166-2:CO", "Colombia", "哥伦比亚"),
	CR("188", "CR", "CRI", "ISO 3166-2:CR", "Costa Rica", "哥斯达黎加"),
	CU("192", "CU", "CUB", "ISO 3166-2:CU", "Cuba", "古巴"),
	CV("132", "CV", "CPV", "ISO 3166-2:CV", "Cape Verde", "佛得角"),
	CX("162", "CX", "CXR", "ISO 3166-2:CX", "Christmas Island", "圣诞岛"),
	CY("196", "CY", "CYP", "ISO 3166-2:CY", "Cyprus", "塞浦路斯"),
	CZ("203", "CZ", "CZE", "ISO 3166-2:CZ", "Czech Republic", "捷克"),
	DE("276", "DE", "DEU", "ISO 3166-2:DE", "Germany", "德国"),
	DJ("262", "DJ", "DJI", "ISO 3166-2:DJ", "Djibouti", "吉布提"),
	DK("208", "DK", "DNK", "ISO 3166-2:DK", "Denmark", "丹麦"),
	DM("212", "DM", "DMA", "ISO 3166-2:DM", "Dominica", "多米尼克"),
	DO("214", "DO", "DOM", "ISO 3166-2:DO", "Dominican Republic", "多米尼加"),
	DZ("012", "DZ", "DZA", "ISO 3166-2:DZ", "Algeria", "阿尔及利亚"),
	EC("218", "EC", "ECU", "ISO 3166-2:EC", "Ecuador", "厄瓜多尔"),
	EE("233", "EE", "EST", "ISO 3166-2:EE", "Estonia", "爱沙尼亚"),
	EG("818", "EG", "EGY", "ISO 3166-2:EG", "Egypt", "埃及"),
	EH("732", "EH", "ESH", "ISO 3166-2:EH", "Western Sahara", "西撒哈拉"), // no ip
	ER("232", "ER", "ERI", "ISO 3166-2:ER", "Eritrea", "厄立特里亚"),
	ES("724", "ES", "ESP", "ISO 3166-2:ES", "Spain", "西班牙"),
	ET("231", "ET", "ETH", "ISO 3166-2:ET", "Ethiopia", "埃塞俄比亚"),
	FI("246", "FI", "FIN", "ISO 3166-2:FI", "Finland", "芬兰"),
	FJ("242", "FJ", "FJI", "ISO 3166-2:FJ", "Fiji", "斐济"),
	FK("238", "FK", "FLK", "ISO 3166-2:FK", "Falkland Islands", "马尔维纳斯群岛（ 福克兰）"), // no ip
	FM("583", "FM", "FSM", "ISO 3166-2:FM", "Federated States of Micronesia", "密克罗尼西亚"),
	FO("234", "FO", "FRO", "ISO 3166-2:FO", "Faroe Islands", "法罗群岛"),
	FR("250", "FR", "FRA", "ISO 3166-2:FR", "France", "法国"),
	GA("266", "GA", "GAB", "ISO 3166-2:GA", "Gabon", "加蓬"),
	GB("826", "GB", "GBR", "ISO 3166-2:GB", "Great Britain (United Kingdom; England)", "英国"),
	GD("308", "GD", "GRD", "ISO 3166-2:GD", "Grenada", "格林纳达"),
	GE("268", "GE", "GEO", "ISO 3166-2:GE", "Georgia", "格鲁吉亚"),
	GF("254", "GF", "GUF", "ISO 3166-2:GF", "French Guiana", "法属圭亚那"),
	GG("831", "GG", "GGY", "ISO 3166-2:GG", "Guernsey", "根西岛"),
	GH("288", "GH", "GHA", "ISO 3166-2:GH", "Ghana", "加纳"),
	GI("292", "GI", "GIB", "ISO 3166-2:GI", "Gibraltar", "直布罗陀"),
	GL("304", "GL", "GRL", "ISO 3166-2:GL", "Greenland", "格陵兰"),
	GM("270", "GM", "GMB", "ISO 3166-2:GM", "Gambia", "冈比亚"),
	GN("324", "GN", "GIN", "ISO 3166-2:GN", "Guinea", "几内亚"),
	GP("312", "GP", "GLP", "ISO 3166-2:GP", "Guadeloupe", "瓜德罗普"),
	GQ("226", "GQ", "GNQ", "ISO 3166-2:GQ", "Equatorial Guinea", "赤道几内亚"),
	GR("300", "GR", "GRC", "ISO 3166-2:GR", "Greece", "希腊"),
	GS("239", "GS", "SGS", "ISO 3166-2:GS", "South Georgia and the South Sandwich Islands", "南乔治亚岛和南桑威奇群岛"),
	GT("320", "GT", "GTM", "ISO 3166-2:GT", "Guatemala", "危地马拉"),
	GU("316", "GU", "GUM", "ISO 3166-2:GU", "Guam", "关岛"),
	GW("624", "GW", "GNB", "ISO 3166-2:GW", "Guinea-Bissau", "几内亚比绍"),
	GY("328", "GY", "GUY", "ISO 3166-2:GY", "Guyana", "圭亚那"),
	HK("344", "HK", "HKG", "ISO 3166-2:HK", "Hong Kong", "中国香港"), // country + city
	HM("334", "HM", "HMD", "ISO 3166-2:HM", "Heard Island and McDonald Islands", "赫德岛和麦克唐纳群岛"), // no ip
	HN("340", "HN", "HND", "ISO 3166-2:HN", "Honduras", "洪都拉斯"),
	HR("191", "HR", "HRV", "ISO 3166-2:HR", "Croatia", "克罗地亚"),
	HT("332", "HT", "HTI", "ISO 3166-2:HT", "Haiti", "海地"),
	HU("348", "HU", "HUN", "ISO 3166-2:HU", "Hungary", "匈牙利"),
	ID("360", "ID", "IDN", "ISO 3166-2:ID", "Indonesia", "印度尼西亚"),
	IE("372", "IE", "IRL", "ISO 3166-2:IE", "Ireland", "爱尔兰"),
	IL("376", "IL", "ISR", "ISO 3166-2:IL", "Israel", "以色列"),
	IM("833", "IM", "IMN", "ISO 3166-2:IM", "Isle of Man", "马恩岛"),
	IN("356", "IN", "IND", "ISO 3166-2:IN", "India", "印度"),
	IO("086", "IO", "IOT", "ISO 3166-2:IO", "British Indian Ocean Territory", "英属印度洋领地"),
	IQ("368", "IQ", "IRQ", "ISO 3166-2:IQ", "Iraq", "伊拉克"),
	IR("364", "IR", "IRN", "ISO 3166-2:IR", "Iran", "伊朗"),
	IS("352", "IS", "ISL", "ISO 3166-2:IS", "Iceland", "冰岛"),
	IT("380", "IT", "ITA", "ISO 3166-2:IT", "Italy", "意大利"),
	JE("832", "JE", "JEY", "ISO 3166-2:JE", "Jersey", "泽西岛"),
	JM("388", "JM", "JAM", "ISO 3166-2:JM", "Jamaica", "牙买加"),
	JO("400", "JO", "JOR", "ISO 3166-2:JO", "Jordan", "约旦"),
	JP("392", "JP", "JPN", "ISO 3166-2:JP", "Japan", "日本"),
	KE("404", "KE", "KEN", "ISO 3166-2:KE", "Kenya", "肯尼亚"),
	KG("417", "KG", "KGZ", "ISO 3166-2:KG", "Kyrgyzstan", "吉尔吉斯斯坦"),
	KH("116", "KH", "KHM", "ISO 3166-2:KH", "Cambodia", "柬埔寨"),
	KI("296", "KI", "KIR", "ISO 3166-2:KI", "Kiribati", "基里巴斯"),
	KM("174", "KM", "COM", "ISO 3166-2:KM", "The Comoros", "科摩罗"),
	KN("659", "KN", "KNA", "ISO 3166-2:KN", "St. Kitts & Nevis", "圣基茨和尼维斯"),
	KP("408", "KP", "PRK", "ISO 3166-2:KP", "North Korea", "朝鲜"),
	KR("410", "KR", "KOR", "ISO 3166-2:KR", "South Korea", "韩国"),
	KW("414", "KW", "KWT", "ISO 3166-2:KW", "Kuwait", "科威特"),
	KY("136", "KY", "CYM", "ISO 3166-2:KY", "Cayman Islands", "开曼群岛"),
	KZ("398", "KZ", "KAZ", "ISO 3166-2:KZ", "Kazakhstan", "哈萨克斯坦"),
	LA("418", "LA", "LAO", "ISO 3166-2:LA", "Laos", "老挝"),
	LB("422", "LB", "LBN", "ISO 3166-2:LB", "Lebanon", "黎巴嫩"),
	LC("662", "LC", "LCA", "ISO 3166-2:LC", "St. Lucia", "圣卢西亚"),
	LI("438", "LI", "LIE", "ISO 3166-2:LI", "Liechtenstein", "列支敦士登"),
	LK("144", "LK", "LKA", "ISO 3166-2:LK", "Sri Lanka", "斯里兰卡"),
	LR("430", "LR", "LBR", "ISO 3166-2:LR", "Liberia", "利比里亚"),
	LS("426", "LS", "LSO", "ISO 3166-2:LS", "Lesotho", "莱索托"),
	LT("440", "LT", "LTU", "ISO 3166-2:LT", "Lithuania", "立陶宛"),
	LU("442", "LU", "LUX", "ISO 3166-2:LU", "Luxembourg", "卢森堡"),
	LV("428", "LV", "LVA", "ISO 3166-2:LV", "Latvia", "拉脱维亚"),
	LY("434", "LY", "LBY", "ISO 3166-2:LY", "Libya", "利比亚"),
	MA("504", "MA", "MAR", "ISO 3166-2:MA", "Morocco", "摩洛哥"),
	MC("492", "MC", "MCO", "ISO 3166-2:MC", "Monaco", "摩纳哥"),
	MD("498", "MD", "MDA", "ISO 3166-2:MD", "Moldova", "摩尔多瓦"),
	ME("499", "ME", "MNE", "ISO 3166-2:ME", "Montenegro", "黑山"),
	MF("663", "MF", "MAF", "ISO 3166-2:MF", "Saint Martin (France)", "圣马丁"),
	MG("450", "MG", "MDG", "ISO 3166-2:MG", "Madagascar", "马达加斯加"),
	MH("584", "MH", "MHL", "ISO 3166-2:MH", "Marshall islands", "马绍尔群岛"),
	MK("807", "MK", "MKD", "ISO 3166-2:MK", "Republic of Macedonia (FYROM)", "马其顿"),
	ML("466", "ML", "MLI", "ISO 3166-2:ML", "Mali", "马里"), // no ip
	MM("104", "MM", "MMR", "ISO 3166-2:MM", "Myanmar (Burma)", "缅甸"),
	MN("496", "MN", "MNG", "ISO 3166-2:MN", "Mongolia", "蒙古"),
	MO("446", "MO", "MAC", "ISO 3166-2:MO", "Macao", "中国澳门"),
	MP("580", "MP", "MNP", "ISO 3166-2:MP", "Northern Mariana Islands", "北马里亚纳群岛"),
	MQ("474", "MQ", "MTQ", "ISO 3166-2:MQ", "Martinique", "马提尼克"),
	MR("478", "MR", "MRT", "ISO 3166-2:MR", "Mauritania", "毛里塔尼亚"),
	MS("500", "MS", "MSR", "ISO 3166-2:MS", "Montserrat", "蒙塞拉特岛"),
	MT("470", "MT", "MLT", "ISO 3166-2:MT", "Malta", "马耳他"),
	MU("480", "MU", "MUS", "ISO 3166-2:MU", "Mauritius", "毛里求斯"),
	MV("462", "MV", "MDV", "ISO 3166-2:MV", "Maldives", "马尔代夫"),
	MW("454", "MW", "MWI", "ISO 3166-2:MW", "Malawi", "马拉维"),
	MX("484", "MX", "MEX", "ISO 3166-2:MX", "Mexico", "墨西哥"),
	MY("458", "MY", "MYS", "ISO 3166-2:MY", "Malaysia", "马来西亚"),
	MZ("508", "MZ", "MOZ", "ISO 3166-2:MZ", "Mozambique", "莫桑比克"),
	NA("516", "NA", "NAM", "ISO 3166-2:NA", "Namibia", "纳米比亚"),
	NC("540", "NC", "NCL", "ISO 3166-2:NC", "New Caledonia", "新喀里多尼亚"),
	NE("562", "NE", "NER", "ISO 3166-2:NE", "Niger", "尼日尔"),
	NF("574", "NF", "NFK", "ISO 3166-2:NF", "Norfolk Island", "诺福克岛"),
	NG("566", "NG", "NGA", "ISO 3166-2:NG", "Nigeria", "尼日利亚"),
	NI("558", "NI", "NIC", "ISO 3166-2:NI", "Nicaragua", "尼加拉瓜"),
	NL("528", "NL", "NLD", "ISO 3166-2:NL", "Netherlands", "荷兰"),
	NO("578", "NO", "NOR", "ISO 3166-2:NO", "Norway", "挪威"),
	NP("524", "NP", "NPL", "ISO 3166-2:NP", "Nepal", "尼泊尔"),
	NR("520", "NR", "NRU", "ISO 3166-2:NR", "Nauru", "瑙鲁"),
	NU("570", "NU", "NIU", "ISO 3166-2:NU", "Niue", "纽埃"),
	NZ("554", "NZ", "NZL", "ISO 3166-2:NZ", "New Zealand", "新西兰"),
	OM("512", "OM", "OMN", "ISO 3166-2:OM", "Oman", "阿曼"),
	PA("591", "PA", "PAN", "ISO 3166-2:PA", "Panama", "巴拿马"),
	PE("604", "PE", "PER", "ISO 3166-2:PE", "Peru", "秘鲁"),
	PF("258", "PF", "PYF", "ISO 3166-2:PF", "French polynesia", "法属波利尼西亚"),
	PG("598", "PG", "PNG", "ISO 3166-2:PG", "Papua New Guinea", "巴布亚新几内亚"),
	PH("608", "PH", "PHL", "ISO 3166-2:PH", "The Philippines", "菲律宾"),
	PK("586", "PK", "PAK", "ISO 3166-2:PK", "Pakistan", "巴基斯坦"),
	PL("616", "PL", "POL", "ISO 3166-2:PL", "Poland", "波兰"),
	PM("666", "PM", "SPM", "ISO 3166-2:PM", "Saint-Pierre and Miquelon", "圣皮埃尔和密克隆群岛"),
	PN("612", "PN", "PCN", "ISO 3166-2:PN", "Pitcairn Islands", "皮特凯恩群岛"), // no ip
	PR("630", "PR", "PRI", "ISO 3166-2:PR", "Puerto Rico", "波多黎各"),
	PS("275", "PS", "PSE", "ISO 3166-2:PS", "Palestinian territories", "巴勒斯坦"),
	PT("620", "PT", "PRT", "ISO 3166-2:PT", "Portugal", "葡萄牙"),
	PW("585", "PW", "PLW", "ISO 3166-2:PW", "Palau", "帕劳"),
	PY("600", "PY", "PRY", "ISO 3166-2:PY", "Paraguay", "巴拉圭"),
	QA("634", "QA", "QAT", "ISO 3166-2:QA", "Qatar", "卡塔尔"),
	RE("638", "RE", "REU", "ISO 3166-2:RE", "Réunion", "留尼旺"),
	RO("642", "RO", "ROU", "ISO 3166-2:RO", "Romania", "罗马尼亚"),
	RS("688", "RS", "SRB", "ISO 3166-2:RS", "Serbia", "塞尔维亚"),
	RU("643", "RU", "RUS", "ISO 3166-2:RU", "Russian Federation", "俄罗斯"),
	RW("646", "RW", "RWA", "ISO 3166-2:RW", "Rwanda", "卢旺达"),
	SA("682", "SA", "SAU", "ISO 3166-2:SA", "Saudi Arabia", "沙特阿拉伯"),
	SB("090", "SB", "SLB", "ISO 3166-2:SB", "Solomon Islands", "所罗门群岛"),
	SC("690", "SC", "SYC", "ISO 3166-2:SC", "Seychelles", "塞舌尔"),
	SD("729", "SD", "SDN", "ISO 3166-2:SD", "Sudan", "苏丹"),
	SE("752", "SE", "SWE", "ISO 3166-2:SE", "Sweden", "瑞典"),
	SG("702", "SG", "SGP", "ISO 3166-2:SG", "Singapore", "新加坡"),
	SH("654", "SH", "SHN", "ISO 3166-2:SH", "St. Helena & Dependencies", "圣赫勒拿"), // no ip
	SI("705", "SI", "SVN", "ISO 3166-2:SI", "Slovenia", "斯洛文尼亚"),
	SJ("744", "SJ", "SJM", "ISO 3166-2:SJ", "Template:Country data SJM Svalbard", "斯瓦尔巴群岛和扬马延岛"), // no ip
	SK("703", "SK", "SVK", "ISO 3166-2:SK", "Slovakia", "斯洛伐克"),
	SL("694", "SL", "SLE", "ISO 3166-2:SL", "Sierra Leone", "塞拉利昂"),
	SM("674", "SM", "SMR", "ISO 3166-2:SM", "San Marino", "圣马力诺"),
	SN("686", "SN", "SEN", "ISO 3166-2:SN", "Senegal", "塞内加尔"),
	SO("706", "SO", "SOM", "ISO 3166-2:SO", "Somalia", "索马里"),
	SR("740", "SR", "SUR", "ISO 3166-2:SR", "Suriname", "苏里南"),
	SS("728", "SS", "SSD", "ISO 3166-2:SS", "South Sudan", "南苏丹"),
	ST("678", "ST", "STP", "ISO 3166-2:ST", "Sao Tome & Principe", "圣多美和普林西比"),
	SV("222", "SV", "SLV", "ISO 3166-2:SV", "El Salvador", "萨尔瓦多"),
	SY("760", "SY", "SYR", "ISO 3166-2:SY", "Syria", "叙利亚"),
	SZ("748", "SZ", "SWZ", "ISO 3166-2:SZ", "Swaziland", "斯威士兰"),
	TC("796", "TC", "TCA", "ISO 3166-2:TC", "Turks & Caicos Islands", "特克斯和凯科斯群岛"),
	TD("148", "TD", "TCD", "ISO 3166-2:TD", "Chad", "乍得"),

	TF("260", "TF", "ATF", "ISO 3166-2:TF", "French Southern Territories", "法属南部领地"), // no ip
	TG("768", "TG", "TGO", "ISO 3166-2:TG", "Togo", "多哥"),
	TH("764", "TH", "THA", "ISO 3166-2:TH", "Thailand", "泰国"),
	TJ("762", "TJ", "TJK", "ISO 3166-2:TJ", "Tajikistan", "塔吉克斯坦"),
	TK("772", "TK", "TKL", "ISO 3166-2:TK", "Tokelau", "托克劳群岛"),
	TL("626", "TL", "TLS", "ISO 3166-2:TP", "Timor-Leste (East Timor)", "东帝汶"),
	TM("795", "TM", "TKM", "ISO 3166-2:TM", "Turkmenistan", "土库曼斯坦"),
	TN("788", "TN", "TUN", "ISO 3166-2:TN", "Tunisia", "突尼斯"),
	TO("776", "TO", "TON", "ISO 3166-2:TO", "Tonga", "汤加"),
	TR("792", "TR", "TUR", "ISO 3166-2:TR", "Turkey", "土耳其"),
	TT("780", "TT", "TTO", "ISO 3166-2:TT", "Trinidad & Tobago", "特立尼达和多巴哥"),
	TV("798", "TV", "TUV", "ISO 3166-2:TV", "Tuvalu", "图瓦卢"),
	TW("158", "TW", "TWN", "ISO 3166-2:TW", "Taiwan", "中国台湾"),
	TZ("834", "TZ", "TZA", "ISO 3166-2:TZ", "Tanzania", "坦桑尼亚"),
	UA("804", "UA", "UKR", "ISO 3166-2:UA", "Ukraine", "乌克兰"),
	UG("800", "UG", "UGA", "ISO 3166-2:UG", "Uganda", "乌干达"),
	UM("581", "UM", "UMI", "ISO 3166-2:UM", "United States Minor Outlying Islands", "美国本土外小岛屿"),  // no ip

	US("840", "US", "USA", "ISO 3166-2:US", "United States of America (USA)", "美国"),
	UY("858", "UY", "URY", "ISO 3166-2:UY", "Uruguay", "乌拉圭"),
	UZ("860", "UZ", "UZB", "ISO 3166-2:UZ", "Uzbekistan", "乌兹别克斯坦"),
	VA("336", "VA", "VAT", "ISO 3166-2:VA", "Vatican City (The Holy See)", "梵蒂冈"),
	VC("670", "VC", "VCT", "ISO 3166-2:VC", "St. Vincent & the Grenadines", "圣文森特和格林纳丁斯"),
	VE("862", "VE", "VEN", "ISO 3166-2:VE", "Venezuela", "委内瑞拉"),
	VG("092", "VG", "VGB", "ISO 3166-2:VG", "British Virgin Islands", "英属维尔京群岛"),
	VI("850", "VI", "VIR", "ISO 3166-2:VI", "United States Virgin Islands", "美属维尔京群岛"),
	VN("704", "VN", "VNM", "ISO 3166-2:VN", "Vietnam", "越南"),
	VU("548", "VU", "VUT", "ISO 3166-2:VU", "Vanuatu", "瓦努阿图"),
	WF("876", "WF", "WLF", "ISO 3166-2:WF", "Wallis and Futuna", "瓦利斯和富图纳"),
	WS("882", "WS", "WSM", "ISO 3166-2:WS", "Samoa", "萨摩亚"),
	YE("887", "YE", "YEM", "ISO 3166-2:YE", "Yemen", "也门"),
	YT("175", "YT", "MYT", "ISO 3166-2:YT", "Mayotte", "马约特"),
	ZA("710", "ZA", "ZAF", "ISO 3166-2:ZA", "South Africa", "南非"),
	ZM("894", "ZM", "ZMB", "ISO 3166-2:ZM", "Zambia", "赞比亚"),
	ZW("716", "ZW", "ZWE", "ISO 3166-2:ZW", "Zimbabwe", "津巴布韦"),

	UK("998", "UK", "UNKNOWN", "", "Unknown", "未知国家地区"),
	TS("999", "TS", "TEST", "", "Test", "测试区域"),

	;

	private String number;

	private String code2;

	private String code3;

	private String iso_code;

	private String iso_name;

	private String cname;

	private String currency;

	private static Logger log = LoggerFactory.getLogger(RegionEnum.class);

	private RegionEnum(String number, String code2, String code3, String iso_code, String iso_name, String cname) {
		this.number = number;
		this.code2 = code2;
		this.code3 = code3;
		this.iso_code = iso_code;
		this.iso_name = iso_name;
		this.cname = cname;
	}

	private RegionEnum(String number, String code2, String code3, String iso_code, String iso_name, String cname, String currency) {
		this.number = number;
		this.code2 = code2;
		this.code3 = code3;
		this.iso_code = iso_code;
		this.iso_name = iso_name;
		this.cname = cname;
		this.currency = currency;
	}

	public String getNumber() {
		return number;
	}

	public String getCode2() {
		return code2;
	}

	public String getCode3() {
		return code3;
	}

	public String getIsoCode() {
		return iso_code;
	}

	public String getIsoName() {
		return iso_name;
	}

	public String getCname() {
		return cname;
	}

	public String getCurrency() {
		return currency;
	}

	public static RegionEnum getByNumber(String number) {
		for (RegionEnum region : RegionEnum.values()) {
			if (region.getNumber().equalsIgnoreCase(number)) {
				return region;
			}
		}
		log.debug("Cannot found RegionEnum with number '" + number + "'.");
		return RegionEnum.UK;
	}

	public static RegionEnum getByCode2(String code2) {
		for (RegionEnum region : RegionEnum.values()) {
			if (region.getCode2().equalsIgnoreCase(code2)) {
				return region;
			}
		}
		log.debug("Cannot found RegionEnum with code2 '" + code2 + "'.");
		return RegionEnum.UK;
	}

	public static RegionEnum getByCode3(String code3) {
		for (RegionEnum region : RegionEnum.values()) {
			if (region.getCode3().equalsIgnoreCase(code3)) {
				return region;
			}
		}
		log.debug("Cannot found RegionEnum with code3 '" + code3 + "'.");
		return RegionEnum.UK;
	}

	public static RegionEnum getByIsoCode(String iso_code) {
		for (RegionEnum region : RegionEnum.values()) {
			if (region.getIsoCode().equalsIgnoreCase(iso_code)) {
				return region;
			}
		}
		log.debug("Cannot found RegionEnum with iso_code '" + iso_code + "'.");
		return RegionEnum.UK;
	}

	public static RegionEnum getByIsoName(String iso_name) {
		for (RegionEnum region : RegionEnum.values()) {
			if (region.getIsoName().equalsIgnoreCase(iso_name)) {
				return region;
			}
		}
		log.debug("Cannot found RegionEnum with iso_name '" + iso_name + "'.");
		return RegionEnum.UK;
	}

	public static RegionEnum getByCnName(String cn_name) {
		for (RegionEnum region : RegionEnum.values()) {
			if (region.getCname().equalsIgnoreCase(cn_name)) {
				return region;
			}
		}
		log.debug("Cannot found RegionEnum with cn_name '" + cn_name + "'.");
		return RegionEnum.UK;
	}

	public static RegionEnum getByRegionAddress(RegionAddress adress) {
		for (RegionEnum region : RegionEnum.values()) {
			if (region.getCname().equalsIgnoreCase(adress.getCountry()) ||
				region.getCname().equalsIgnoreCase(adress.getCountry() + adress.getCity())) {
				return region;
			}
		}
		log.debug("Cannot found RegionEnum with '" + adress.toString() + "'.");
		return RegionEnum.UK;
	}

	public static boolean isValidRegion(RegionEnum region) {
		return !RegionEnum.UK.equals(region) && !RegionEnum.TS.equals(region);
	}

	public static boolean isChinaRegion(RegionEnum region) {
		return RegionEnum.CN.equals(region) || RegionEnum.HK.equals(region) || RegionEnum.MO.equals(region) || RegionEnum.TW.equals(region);
	}

	public static boolean isChinaRegion(String countryCode) {
		RegionEnum region = RegionEnum.getByCode2(countryCode);
		if(RegionEnum.UK.equals(region)) {
			region = RegionEnum.getByCode3(countryCode);
		}
		return isChinaRegion(region);
	}

	public static boolean isMainland(String countryCode) {
		RegionEnum region = RegionEnum.getByCode2(countryCode);
		if(RegionEnum.UK.equals(region)) {
			region = RegionEnum.getByCode3(countryCode);
		}
		return RegionEnum.CN.equals(region);
	}

	public boolean isValidRegion() {
		return !RegionEnum.UK.equals(this) && !RegionEnum.TS.equals(this);
	}

	public boolean isChinaRegion() {
		return RegionEnum.CN.equals(this) || RegionEnum.HK.equals(this) || RegionEnum.MO.equals(this) || RegionEnum.TW.equals(this);
	}

	public boolean isChinaMainland() {
		return RegionEnum.CN.equals(this);
	}

	public boolean equals(RegionEnum region) {
		return this.compareTo(region) == 0;
	}

}
