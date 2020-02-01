package bijoytounicode;

import java.util.HashMap;
import java.util.Map;

/**
 * Document   : Bijoy to Unicode (UTF-8) converter
 * Created on : June 19, 2016, 10:30 AM
 *
 * @author : Rafiqunnabi Nayan
 * Email      : rafiq.nayan@gmail.com
 * Organization  : http://progoti.com
 * <p/>
 * Description: Converts any string (no virtual length limitation) written in Bijoy fonts (SutonnyMJ etc) to Unicode format.
 * <p/>
 * Usage: 1. import the com.progoti.tools.converter.BijoyToUnicodeConverter class
 * 2. call the convert method
 * <p/>
 * Pre-requisite: N/A
 * <p/>
 * Credits:
 * This is a java port of a php script.
 * <p/>
 * Notes on the php script
 * Created on : Mar 10, 2012, 10:23:43 AM
 * @author : Habib Ullah Bahar
 * Email      : bahar@progmaatic.com
 * Organization  : http://progmaatic.com
 * <p/>
 * Copyright:
 * GNU AFFERO GENERAL PUBLIC LICENSE, Version 3 (AGPL-3.0)
 */

/**
 * An utility class to convert bijoy text to unicode
 */
public class BijoyToUnicodeConverter {
    private static Map<String, String> preConversionMap = new HashMap<String, String>();
    private static Map<String, String> conversionMap = new HashMap<String, String>();
    private static Map<String, String> proConversionMap = new HashMap<String, String>();
    private static Map<String, String> postConversionMap = new HashMap<String, String>();
//bijoy to unicode map fontfamily =sutonnymj   
//String a="iÂ¨":"à¦°â€Œà§à¦¯","ÂªÂ¨":"à§à¦°à§à¦¯","Â°":"à¦•à§à¦•","Â±":"à¦•à§à¦Ÿ","Â³":"à¦•à§à¦¤","KÂ¡":"à¦•à§à¦¬","Â¯Å’":"à¦¸à§à¦•à§à¦°","Âµ":"à¦•à§à¦°","KÂ¬":"à¦•à§à¦²","Â¶":"à¦•à§à¦·","Ã¿":"à¦•à§à¦·","Â·":"à¦•à§à¦¸","Â¸":"à¦—à§","Â»":"à¦—à§à¦§","MÅ“":"à¦—à§à¦¨","MÂ¥":"à¦—à§à¦®","MÂ­":"à¦—à§à¦²","Â¼":"à¦™à§à¦•","â€¢Â¶":"à¦™à§à¦•à§à¦·","â€¢L":"à¦™à§à¦–","Â½":"à¦™à§à¦—","â€¢N":"à¦™à§à¦˜","â€¢":"à¦•à§à¦¸","â€P":"à¦šà§à¦š","â€Q":"à¦šà§à¦›","â€QÂ¡":"à¦šà§à¦›à§à¦¬","â€T":"à¦šà§à¦ž","Â¾Â¡":"à¦œà§à¦œà§à¦¬","Â¾":"à¦œà§à¦œ","Ã€":"à¦œà§à¦","Ã":"à¦œà§à¦ž","RÂ¡":"à¦œà§à¦¬","Ã‚":"à¦žà§à¦š","Ãƒ":"à¦žà§à¦›","Ã„":"à¦žà§à¦œ","Ã…":"à¦žà§à¦","Ã†":"à¦Ÿà§à¦Ÿ","UÂ¡":"à¦Ÿà§à¦¬","UÂ¥":"à¦Ÿà§à¦®","Ã‡":"à¦¡à§à¦¡","Ãˆ":"à¦£à§à¦Ÿ","Ã‰":"à¦£à§à¦ ","Ã":"à¦¨à§à¦¸","ÃŠ":"à¦£à§à¦¡","Å¡â€˜":"à¦¨à§à¦¤à§","Y\\^":"à¦£à§à¦¬","Ã‹":"à¦¤à§à¦¤","Ã‹Â¡":"à¦¤à§à¦¤à§à¦¬","ÃŒ":"à¦¤à§à¦¥","ZÂ¥":"à¦¤à§à¦®","Å¡â€”Â¡":"à¦¨à§à¦¤à§à¦¬","ZÂ¡":"à¦¤à§à¦¬","ÃŽ":"à¦¤à§à¦°","_Â¡":"à¦¥à§à¦¬","ËœM":"à¦¦à§à¦—","ËœN":"à¦¦à§à¦˜","Ã":"à¦¦à§à¦¦","Ã—":"à¦¦à§à¦§","ËœÂ¡":"à¦¦à§à¦¬","Ã˜":"à¦¦à§à¦¬","â„¢Â¢":"à¦¦à§à¦­","Ã™":"à¦¦à§à¦®","`Âªâ€œ":"à¦¦à§à¦°à§","aÅ¸":"à¦§à§à¦¬","aÂ¥":"à¦§à§à¦®","â€ºU":"à¦¨à§à¦Ÿ","Ãš":"à¦¨à§à¦ ","Ã›":"à¦¨à§à¦¡","Å¡Ã":"à¦¨à§à¦¤","Å¡â€”":"à¦¨à§à¦¤","Å¡Â¿":"à¦¨à§à¦¤à§à¦°","Å¡â€™":"à¦¨à§à¦¥","â€º`":"à¦¨à§à¦¦","â€ºÃ˜":"à¦¨à§à¦¦à§à¦¬","Ãœ":"à¦¨à§à¦§","bÅ“":"à¦¨à§à¦¨","Å¡\\^":"à¦¨à§à¦¬","bÂ¥":"à¦¨à§à¦®","Ãž":"à¦ªà§à¦Ÿ","ÃŸ":"à¦ªà§à¦¤","cÅ“":"à¦ªà§à¦¨","Ã ":"à¦ªà§à¦ª","cÃ¸":"à¦ªà§à¦²","cÂ­":"à¦ªà§à¦²","Ã¡":"à¦ªà§à¦¸","dÂ¬":"à¦«à§à¦²","Ã¢":"à¦¬à§à¦œ","Ã£":"à¦¬à§à¦¦","Ã¤":"à¦¬à§à¦§","eÅ¸":"à¦¬à§à¦¬","eÂ­":"à¦¬à§à¦²","Ã¥":"à¦­à§à¦°","gÅ“":"à¦®à§à¦¨","Â¤Ãº":"à¦®à§à¦ª","Ã§":"à¦®à§à¦«","Â¤\\^":"à¦®à§à¦¬","Â¤Â¢":"à¦®à§à¦­","Â¤Â£":"à¦®à§à¦­à§à¦°","Â¤Â§":"à¦®à§à¦®","Â¤Â­":"à¦®à§à¦²","iâ€œ":"à¦°à§","iÃ¦":"à¦°à§","iÆ’":"à¦°à§‚","Ã©":"à¦²à§à¦•","Ãª":"à¦²à§à¦—","Ã«":"à¦²à§à¦Ÿ","Ã¬":"à¦²à§à¦¡","Ã­":"à¦²à§à¦ª","Ã®":"à¦²à§à¦«","jÂ¦":"à¦²à§à¦¬","jÂ¥":"à¦²à§à¦®","jÃ¸":"à¦²à§à¦²","Ã¯":"à¦¶à§","Ã°":"à¦¶à§à¦š","kÅ“":"à¦¶à§à¦¨","kÃ¸":"à¦¶à§à¦²","kÂ¦":"à¦¶à§à¦¬","kÂ¥":"à¦¶à§à¦®","kÂ­":"à¦¶à§à¦²","Â®â€¹":"à¦·à§à¦•","Â®Å’":"à¦·à§à¦•à§à¦°","Ã³":"à¦·à§à¦Ÿ","Ã´":"à¦·à§à¦ ","Ã²":"à¦·à§à¦£","Â®Ãº":"à¦·à§à¦ª","Ãµ":"à¦·à§à¦«","Â®Â§":"à¦·à§à¦®","Â¯â€¹":"à¦¸à§à¦•","Ã·":"à¦¸à§à¦Ÿ","Ã¶":"à¦¸à§à¦–","Â¯â€”":"à¦¸à§à¦¤","Â¯Ã":"à¦¸à§à¦¤","Â¯â€˜":"à¦¸à§à¦¤à§","Â¯Â¿":"à¦¸à§à¦¤à§à¦°","Â¯â€™":"à¦¸à§à¦¥","mÅ“":"à¦¸à§à¦¨","Â¯Ãº":"à¦¸à§à¦ª","Ã¹":"à¦¸à§à¦«","Â¯\\^":"à¦¸à§à¦¬","Â¯Â§":"à¦¸à§à¦®","Â¯Â­":"à¦¸à§à¦²","Ã»":"à¦¹à§","nÃ¨":"à¦¹à§à¦£","Ã½":"à¦¹à§à¦¨","Ã¾":"à¦¹à§à¦®","nÂ¬":"à¦¹à§à¦²","Ã¼":"à¦¹à§ƒ","Â©":"à¦°à§","Av":"à¦†","A":"à¦…","B":"à¦‡","C":"à¦ˆ","D":"à¦‰","E":"à¦Š","F":"à¦‹","G":"à¦","H":"à¦","I":"à¦“","J":"à¦”","K":"à¦•","L":"à¦–","M":"à¦—","N":"à¦˜","O":"à¦™","P":"à¦š","Q":"à¦›","R":"à¦œ","S":"à¦","T":"à¦ž","U":"à¦Ÿ","V":"à¦ ","W":"à¦¡","X":"à¦¢","Y":"à¦£","Z":"à¦¤","_":"à¦¥","`":"à¦¦","a":"à¦§","b":"à¦¨","c":"à¦ª","d":"à¦«","e":"à¦¬","f":"à¦­","g":"à¦®","h":"à¦¯","i":"à¦°","j":"à¦²","k":"à¦¶","l":"à¦·","m":"à¦¸","n":"à¦¹","o":"à§œ","p":"à§","q":"à§Ÿ","r":"à§Ž","0":"à§¦","1":"à§§","2":"à§¨","3":"à§©","4":"à§ª","5":"à§«","6":"à§¬","7":"à§­","8":"à§®","9":"à§¯","v":"à¦¾","w":"à¦¿","x":"à§€","y":"à§","z":"à§","~":"à§‚","â€ž":"à§ƒ","â€¡":"à§‡","â€ ":"à§‡","â€°":"à§ˆ","\\Ë†":"à§ˆ","Å ":"à§—","Ã”":"â€˜","Ã•":"â€™","\\|":"à¥¤","Ã’":"â€œ","Ã“":"â€","s":"à¦‚","t":"à¦ƒ","u":"à¦","Âª":"à§à¦°","Ã–":"à§à¦°","Â«":"à§à¦°","Â¨":"à§à¦¯","\\&":"à§","â€¦":"à§ƒ";
    static {
        preConversionMap.put(" +", " ");
        preConversionMap.put("yy", "y"); //Double Hrosh-u-Kar
        preConversionMap.put("vv", "v"); //Double Aa-Kar
        preConversionMap.put("��", "�"); //Double Jukto-L - L+Double-L = Triple L
        preConversionMap.put("y&", "y"); //Hoshonto+Hrosh-u
        preConversionMap.put("�&", "�"); //Hoshonto+Ri-Kar
        preConversionMap.put("�u", "u�"); //ChondroBindu Error /Typing Mistake
        preConversionMap.put("wu", "uw"); //ChondroBindu Error /Typing Mistake
        preConversionMap.put(" ,", ",");
        preConversionMap.put(" \\|", "\\|");
        preConversionMap.put("\\\\ ", "");
        preConversionMap.put(" \\\\", "");
        preConversionMap.put("\\\\", "");
        preConversionMap.put("\n +", "\n");
        preConversionMap.put(" +\n", "\n");
        preConversionMap.put("\n\n\n\n\n", "\n\n");
        preConversionMap.put("\n\n\n\n", "\n\n");
        preConversionMap.put("\n\n\n", "\n\n");

// Vowels Start
        conversionMap.put("Av", "আ");
        conversionMap.put("A", "অ");
        conversionMap.put("B", "ই");
        conversionMap.put("C", "ঈ");
        conversionMap.put("D", "উ");
        conversionMap.put("E", "ঊ");
        conversionMap.put("F", "ঋ");
        conversionMap.put("G", "এ");
        conversionMap.put("H", "ঐ");
        conversionMap.put("I", "ও");
        conversionMap.put("J", "ঔ");
        // Constants
        conversionMap.put("K", "ক");
        conversionMap.put("L", "খ");
        conversionMap.put("M", "গ");
        conversionMap.put("N", "ঘ");
        conversionMap.put("O", "ঙ");
        conversionMap.put("P", "চ");
        conversionMap.put("Q", "ছ");
        conversionMap.put("R", "জ");
        conversionMap.put("S", "ঝ");
        conversionMap.put("T", "ঞ");
        conversionMap.put("U", "ট");
        conversionMap.put("V", "ঠ");
        conversionMap.put("W", "ড");
        conversionMap.put("X", "ঢ");
        conversionMap.put("Y", "ণ");
        conversionMap.put("Z", "ত");
        conversionMap.put("_", "থ");
        conversionMap.put("`", "দ");
        conversionMap.put("a", "ধ");
        conversionMap.put("b", "ন");
        conversionMap.put("c", "প");
        conversionMap.put("d", "ফ");
        conversionMap.put("e", "ব");
        conversionMap.put("f", "ভ");
        conversionMap.put("g", "ম");
        conversionMap.put("h", "য");
        conversionMap.put("i", "র");
        conversionMap.put("j", "ল");
        conversionMap.put("k", "শ");
        conversionMap.put("l", "ষ");
        conversionMap.put("m", "স");
        conversionMap.put("n", "হ");
        conversionMap.put("o", "ড়");
        conversionMap.put("p", "ঢ়");
        conversionMap.put("q", "য়");
        conversionMap.put("r", "ৎ");
        conversionMap.put("s", "ং");
        conversionMap.put("t", "ঃ");
        conversionMap.put("u", "ঁ");
        // Numbers
        conversionMap.put("0", "০");
        conversionMap.put("1", "১");
        conversionMap.put("2", "২");
        conversionMap.put("3", "৩");
        conversionMap.put("4", "৪");
        conversionMap.put("5", "৫");
        conversionMap.put("6", "৬");
        conversionMap.put("7", "৭");
        conversionMap.put("8", "৮");
        conversionMap.put("9", "৯");
        // Kars
        conversionMap.put("•", "ঙ্");
        conversionMap.put("v", "া"); // Aa-Kar
        conversionMap.put("w", "ি"); // i-Kar
        conversionMap.put("x", "ী"); // I-Kar
        conversionMap.put("y", "ু"); // u-Kar
        conversionMap.put("z", "ু"); // u-Kar
        conversionMap.put("“", "ু"); // u-kar
        conversionMap.put("–", "ু"); // u-kar
        conversionMap.put("~", "ূ"); // U-kar
        conversionMap.put("ƒ", "ূ"); // U-kaar
        conversionMap.put("‚", "ূ"); // U-kaar
        conversionMap.put("„„", "ৃ"); //Double Rri-kar Bug
        conversionMap.put("„", "ৃ"); // Ri-Kar
        conversionMap.put("…", "ৃ"); // Ri-Kar
        conversionMap.put("†", "ে"); // E-Kar
        conversionMap.put("‡", "ে"); // E-Kar
        conversionMap.put("ˆ", "ৈ"); // Oi-Kar
        conversionMap.put("‰", "ৈ"); // Oi-Kar
        conversionMap.put("Š", "ৗ"); // Ou-Kar
        conversionMap.put("\\|", "।"); // Full-Stop
        conversionMap.put("\\&", "্‌"); // Ho-shonto
        //	Jukto Okkhor
        conversionMap.put("\\^", "্ব");
        conversionMap.put("‘", "্তু");
        conversionMap.put("’", "্থ");
        conversionMap.put("‹", "্ক");
        conversionMap.put("Œ", "্ক্র");
        conversionMap.put("”", "চ্");
        conversionMap.put("—", "্ত");
        conversionMap.put("˜", "দ্");
        conversionMap.put("™", "দ্");
        conversionMap.put("š", "ন্");
        conversionMap.put("›", "ন্");
        conversionMap.put("œ", "্ন");
        conversionMap.put("Ÿ", "্ব");
        conversionMap.put("¡", "্ব");
        conversionMap.put("¢", "্ভ");
        conversionMap.put("£", "্ভ্র");
        conversionMap.put("¤", "ম্");
        conversionMap.put("¥", "্ম");
        conversionMap.put("¦", "্ব");
        conversionMap.put("§", "্ম");
        conversionMap.put("¨", "্য");
        conversionMap.put("©", "র্");
        conversionMap.put("ª", "্র");
        conversionMap.put("«", "্র");
        conversionMap.put("¬", "্ল");
        conversionMap.put("­", "্ল");
        conversionMap.put("®", "ষ্");
        conversionMap.put("¯", "স্");
        conversionMap.put("°", "ক্ক");
        conversionMap.put("±", "ক্ট");
        conversionMap.put("²", "ক্ষ্ণ"); //shu(kkhno)
        conversionMap.put("³", "ক্ত");
        conversionMap.put("´", "ক্ম");
        conversionMap.put("µ", "ক্র");
        conversionMap.put("¶", "ক্ষ");
        conversionMap.put("·", "ক্স");
        conversionMap.put("¸", "গু");
        conversionMap.put("¹", "জ্ঞ");
        conversionMap.put("º", "গ্দ");
        conversionMap.put("»", "গ্ধ");
        conversionMap.put("¼", "ঙ্ক");
        conversionMap.put("½", "ঙ্গ");
        conversionMap.put("¾", "জ্জ");
        conversionMap.put("¿", "্ত্র");
        conversionMap.put("À", "জ্ঝ");
        conversionMap.put("Á", "জ্ঞ");
        conversionMap.put("Â", "ঞ্চ");
        conversionMap.put("Ã", "ঞ্ছ");
        conversionMap.put("Ä", "ঞ্জ");
        conversionMap.put("Å", "ঞ্ঝ");
        conversionMap.put("Æ", "ট্ট");
        conversionMap.put("Ç", "ড্ড");
        conversionMap.put("È", "ণ্ট");
        conversionMap.put("É", "ণ্ঠ");
        conversionMap.put("Ê", "ণ্ড");
        conversionMap.put("Ë", "ত্ত");
        conversionMap.put("Ì", "ত্থ");
        conversionMap.put("Í", "ত্ম");
        conversionMap.put("Î", "ত্র");
        conversionMap.put("Ï", "দ্দ");
        conversionMap.put("Ð", "-");
        conversionMap.put("Ñ", "-");
        conversionMap.put("Ò", "\"");
        conversionMap.put("Ó", "\"");
        conversionMap.put("Ô", "\'");
        conversionMap.put("Õ", "\'");
        conversionMap.put("Ö", "্র");
        conversionMap.put("×", "দ্ধ");
        conversionMap.put("Ø", "দ্ব");
        conversionMap.put("Ù", "দ্ম");
        conversionMap.put("Ú", "ন্ঠ");
        conversionMap.put("Û", "ন্ড");
        conversionMap.put("Ü", "ন্ধ");
        conversionMap.put("Ý", "ন্স");
        conversionMap.put("Þ", "প্ট");
        conversionMap.put("ß", "প্ত");
        conversionMap.put("à", "প্প");
        conversionMap.put("á", "প্স");
        conversionMap.put("â", "ব্জ");
        conversionMap.put("ã", "ব্দ");
        conversionMap.put("ä", "ব্ধ");
        conversionMap.put("å", "ভ্র");
        conversionMap.put("æ", "ম্ন");
        conversionMap.put("ç", "ম্ফ");
        conversionMap.put("è", "্ন");
        conversionMap.put("é", "ল্ক");
        conversionMap.put("ê", "ল্গ");
        conversionMap.put("ë", "ল্ট");
        conversionMap.put("ì", "ল্ড");
        conversionMap.put("í", "ল্প");
        conversionMap.put("î", "ল্ফ");
        conversionMap.put("ï", "শু");
        conversionMap.put("ð", "শ্চ");
        conversionMap.put("ñ", "শ্ছ");
        conversionMap.put("ò", "ষ্ণ");
        conversionMap.put("ó", "ষ্ট");
        conversionMap.put("ô", "ষ্ঠ");
        conversionMap.put("õ", "ষ্ফ");
        conversionMap.put("ö", "স্খ");
        conversionMap.put("÷", "স্ট");
        conversionMap.put("ø", "স্ন"); //(sn)eho //†ønØ
        conversionMap.put("ù", "স্ফ");
        conversionMap.put("ú", "্প");
        conversionMap.put("û", "হু");
        conversionMap.put("ü", "হৃ");
        conversionMap.put("ý", "হ্ন");
        conversionMap.put("þ", "হ্ম");

        proConversionMap.put("্্", "্");

        postConversionMap.put("০ঃ", "০:");
        postConversionMap.put("১ঃ", "১:");
        postConversionMap.put("২ঃ", "২:");
        postConversionMap.put("৩ঃ", "৩:");
        postConversionMap.put("৪ঃ", "৪:");
        postConversionMap.put("৫ঃ", "৫:");
        postConversionMap.put("৬ঃ", "৬:");
        postConversionMap.put("৭ঃ", "৭:");
        postConversionMap.put("৮ঃ", "৮:");
        postConversionMap.put("৯ঃ", "৯:");
        postConversionMap.put(" ঃ", " :");
        postConversionMap.put("\nঃ", "\n:");
        postConversionMap.put("]ঃ", "]:");
        postConversionMap.put("\\[ঃ", "\\[:");
        postConversionMap.put("  ", " ");
        postConversionMap.put("অা", "আ");
        postConversionMap.put("্‌্‌", "্‌");
    }

    private static boolean isBanglaDigit(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c >= '০' && c <= '৯')
                return true;
        }
        return false;
    }

    private static boolean isBanglaPreKar(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c == 'ি' || c == 'ৈ' || c == 'ে')
                return true;
        }
        return false;
    }

    private static boolean isBanglaPostKar(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c == 'া' || c == 'ো' || c == 'ৌ' || c == 'ৗ' || c == 'ু' || c == 'ূ' || c == 'ী' || c == 'ৃ')
                return true;
        }
        return false;
    }

    private static boolean isBanglaKar(String str, int index) {
        if (isBanglaPreKar(str, index) || isBanglaPostKar(str, index))
            return true;
        return false;
    }

    private static boolean isBanglaBanjonborno(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c == 'ক' || c == 'খ' || c == 'গ' || c == 'ঘ' || c == 'ঙ' || c == 'চ' || c == 'ছ' || c == 'জ'
                    || c == 'ঝ' || c == 'ঞ' || c == 'ট' || c == 'ঠ' || c == 'ড' || c == 'ঢ' || c == 'ণ' || c == 'ত'
                    || c == 'থ' || c == 'দ' || c == 'ধ' || c == 'ন' || c == 'প' || c == 'ফ' || c == 'ব' || c == 'ভ'
                    || c == 'ম' || c == 'য' || c == 'র' || c == 'ল' || c == 'শ' || c == 'ষ' || c == 'স' || c == 'হ'
                    || c == '়' || c == '়' || c == '়' || c == 'ৎ' || c == 'ং' || c == 'ঃ' || c == 'ঁ')
                return true;
        }
        return false;
    }

    private static boolean isBanglaSoroborno(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c == 'অ' || c == 'আ' || c == 'ই' || c == 'ঈ' || c == 'উ' || c == 'ঊ' || c == 'ঋ' || c == 'ঌ' || c == 'এ' || c == 'ঐ' || c == 'ও' || c == 'ঔ')
                return true;
        }
        return false;
    }

    private static boolean isBanglaNukta(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c == 'ঁ')
                return true;
        }
        return false;
    }

    private static boolean isBanglaHalant(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c == '্')
                return true;
        }
        return false;
    }

    private static boolean isSpace(String str, int index) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            if (c == ' ' || c == '\t' || c == '\n' || c == '\r')
                return true;
        }
        return false;
    }

    private static boolean isCharacterMatches(String str, int index, char target) {
        if (index >= 0 && index < str.length()) {
            char c = mbCharAt(str, index);
            return (c == target);
        }
        return false;
    }

    private static String doCharMap(String srcString, Map<String, String> charMap) {

        for (Map.Entry<String, String> entry : charMap.entrySet()) {
            srcString = srcString.replaceAll(entry.getKey(), entry.getValue());
        }

        return srcString;
    }

    private static char mbCharAt(String s, int index) {
        return s.charAt(index);
    }

    private static String subString(String string, int from, int to) {
        return string.substring(from, to);
    }

    private static String reArrangeUnicodeConvertedText(String str) {

        for (int i = 0; i < str.length(); ++i) {

            // Change refs
            if (i < (str.length() - 1) && mbCharAt(str, i) == 'র' && isBanglaHalant(str, i + 1)
                    && !isBanglaHalant(str, i - 1)) {
                int j = 1;
                while (true) {
                    if (i - j < 0) {
                        break;
                    }
                    if (isBanglaBanjonborno(str, i - j) && isBanglaHalant(str, i - j - 1)) {
                        j += 2;
                    } else if (j == 1 && isBanglaKar(str, i - j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                String temp = subString(str, 0, i - j);
                temp += mbCharAt(str, i);
                temp += mbCharAt(str, i + 1);
                temp += subString(str, i - j, i);
                temp += subString(str, i + 2, str.length());
                str = temp;
                i += 1;
                continue;
            }
        }

        str = doCharMap(str, proConversionMap);

        for (int i = 0; i < str.length(); ++i) {

            if (i < str.length() - 1 && mbCharAt(str, i) == 'র' && isBanglaHalant(str, i + 1)
                    && !isBanglaHalant(str, i - 1) && isBanglaHalant(str, i + 2)) {
                int j = 1;
                while (true) {
                    if (i - j < 0) {
                        break;
                    }
                    if (isBanglaBanjonborno(str, i - j) && isBanglaHalant(str, i - j - 1)) {
                        j += 2;
                    } else if (j == 1 && isBanglaKar(str, i - j)) {
                        j++;
                    } else {
                        break;
                    }
                }
                String temp = subString(str, 0, i - j);
                temp += mbCharAt(str, i);
                temp += mbCharAt(str, i + 1);
                temp += subString(str, i - j, i);
                temp += subString(str, i + 2, str.length());
                str = temp;
                i += 1;
                continue;
            }

            // for 'Vowel + HALANT + Consonant' it should be 'HALANT + Consonant + Vowel'
            if (i > 0 && isCharacterMatches(str, i, '\u09CD') && (isBanglaKar(str, i - 1) || isBanglaNukta(str, i - 1))
                    && i < str.length() - 1) {
                String temp = subString(str, 0, i - 1);
                temp += mbCharAt(str, i);
                temp += mbCharAt(str, i + 1);
                temp += mbCharAt(str, i - 1);
                temp += subString(str, i + 2, str.length());
                str = temp;
            }

            // for 'RA (\u09B0) + HALANT + Vowel' it should be 'Vowel + RA (\u09B0) + HALANT'
            if (i > 0 && i < str.length() - 1 && isCharacterMatches(str, i, '\u09CD') && isCharacterMatches(str, i - 1, '\u09B0')
                    && isCharacterMatches(str, i - 2, '\u09CD') && isBanglaKar(str, i + 1)) {
                String temp = subString(str, 0, i - 1);
                temp += mbCharAt(str, i + 1);
                temp += mbCharAt(str, i - 1);
                temp += mbCharAt(str, i);
                temp += subString(str, i + 2, str.length());
                str = temp;
            }


            // Change pre-kar to post format suitable for unicode
            if (i < str.length() - 1 && isBanglaPreKar(str, i) && isSpace(str, i + 1) == false) {
                String temp = subString(str, 0, i);

                int j = 1;

                while ((i + j) < str.length() - 1 && isBanglaBanjonborno(str, i + j)) {
                    if ((i + j) < str.length() && isBanglaHalant(str, i + j + 1)) {
                        j += 2;
                    } else {
                        break;
                    }
                }
                temp += subString(str, i + 1, i + j + 1);

                int l = 0;
                if (isCharacterMatches(str, i, 'ে') && isCharacterMatches(str, i + j + 1, 'া')) {
                    temp += "ো";
                    l = 1;
                } else if (isCharacterMatches(str, i, 'ে') && isCharacterMatches(str, i + j + 1, 'ৗ')) {
                    temp += "ৌ";
                    l = 1;
                } else {
                    temp += mbCharAt(str, i);
                }
                temp += subString(str, i + j + l + 1, str.length());
                str = temp;
                i += j;
            }

            // nukta should be placed after kars
            if (i < str.length() - 1 && isBanglaNukta(str, i) && isBanglaPostKar(str, i + 1)) {
                String temp = subString(str, 0, i);
                temp += mbCharAt(str, i + 1);
                temp += mbCharAt(str, i);
                temp += subString(str, i + 2, str.length());
                str = temp;
            }
        }

        return str;
    }

    /**
     * Converts a string written in Bijoy to Unicode.
     *
     * @param bijoyString input string in Bijoy
     * @return string in unicode
     */
    public static String convert(String bijoyString) {

        bijoyString = doCharMap(bijoyString, preConversionMap);
        bijoyString = doCharMap(bijoyString, conversionMap);
        bijoyString = reArrangeUnicodeConvertedText(bijoyString);
        bijoyString = doCharMap(bijoyString, postConversionMap);
        return bijoyString;
    }

}
