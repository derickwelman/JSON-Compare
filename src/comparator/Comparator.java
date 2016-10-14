package comparator;

import org.json.*;

public class Comparator {
	public static void main(String args[]) {
		//JSONArray expected = new JSONArray("[{idbee:17,name:Luke Silas,honey:2.98},{idbee:31,name:Narelle Sherrie,honey:3.37},{idbee:7,name:Luther Randal,honey:4.09},{idbee:9,name:Karrie Nigel,honey:7.59},{idbee:13,name:Amanda Janette,honey:18.72},{idbee:4,name:Donna Romy,honey:6.11},{idbee:8,name:Euphemia Lissa,honey:4.05},{idbee:12,name:Kegan Jerrod,honey:0.24},{idbee:26,name:Paisley Alisha,honey:2.10},{idbee:6,name:Amie Kyler,honey:2.30},{idbee:21,name:Cavan Emelia,honey:7.48},{idbee:32,name:Jarred Claud,honey:6.58},{idbee:18,name:Phillipa Ros,honey:4.03},{idbee:11,name:Tilly Andie,honey:5.65},{idbee:23,name:Walt Tittus,honey:1.12},{idbee:28,name:Dorita Eustace,honey:3.74},{idbee:19,name:JoBeth Tim,honey:4.27},{idbee:22,name:Ripley Goodwin,honey:0.98},{idbee:33,name:Mandi Adeline,honey:8.48},{idbee:3,name:Brandt Jenna,honey:9.99},{idbee:24,name:Mitch Denny,honey:5.17},{idbee:5,name:Robby Salina,honey:8.75},{idbee:25,name:Dawn Georgene,honey:7.41},{idbee:14,name:Rowina Emerson,honey:5.13},{idbee:16,name:Kaitlynn Carver,honey:6.20},{idbee:29,name:Aldous Mikki,honey:7.42},{idbee:27,name:Pauletta Pearl,honey:1.69},{idbee:15,name:Kaycee Coretta,honey:6.05},{idbee:10,name:Lorne Beulah,honey:7.46},{idbee:20,name:Ophelia Richmaly,honey:32.19},{idbee:2,name:Diana Portia,honey:0.78},{idbee:1,name:Edwina Lowell,honey:25.31},{idbee:30,name:Timotha Marci,honey:5.98}]");
		//JSONArray source = new JSONArray("[{idbee:1,name:Edwina Lowell,honey:25.31},{idbee:2,name:Diana Portia,honey:0.78},{idbee:3,name:Brandt Jenna,honey:9.99},{idbee:4,name:Donna Romy,honey:6.11},{idbee:5,name:Robby Salina,honey:8.75},{idbee:6,name:Amie Kyler,honey:2.30},{idbee:7,name:Luther Randal,honey:4.09},{idbee:8,name:Euphemia Lissa,honey:4.05},{idbee:9,name:Karrie Nigel,honey:7.59},{idbee:10,name:Lorne Beulah,honey:7.46},{idbee:11,name:Tilly Andie,honey:5.65},{idbee:12,name:Kegan Jerrod,honey:0.24},{idbee:13,name:Amanda Janette,honey:18.72},{idbee:14,name:Rowina Emerson,honey:5.13},{idbee:15,name:Kaycee Coretta,honey:6.05},{idbee:16,name:Kaitlynn Carver,honey:6.20},{idbee:17,name:Luke Silas,honey:2.98},{idbee:18,name:Phillipa Ros,honey:4.03},{idbee:19,name:JoBeth Tim,honey:4.27},{idbee:20,name:Ophelia Richmaly,honey:32.19},{idbee:21,name:Cavan Emelia,honey:7.48},{idbee:22,name:Ripley Goodwin,honey:0.98},{idbee:23,name:Walt Tittus,honey:1.12},{idbee:24,name:Mitch Denny,honey:5.17},{idbee:25,name:Dawn Georgene,honey:7.41},{idbee:26,name:Paisley Alisha,honey:2.10},{idbee:27,name:Pauletta Pearl,honey:1.69},{idbee:28,name:Dorita Eustace,honey:3.74},{idbee:29,name:Aldous Mikki,honey:7.42},{idbee:30,name:Timotha Marci,honey:5.98},{idbee:31,name:Narelle Sherrie,honey:3.37},{idbee:32,name:Jarred Claud,honey:6.58},{idbee:33,name:Mandi Adeline,honey:8.48}]");
		
		if(args.length==2){
			JSONArray expected = new JSONArray(args[0]);
			JSONArray source = new JSONArray(args[1]);
			System.out.println(deepCompareArray(expected, source));
		}else{
			System.out.println("Error: two arguments must be given for the operation");
		}
	}

	public static boolean deepCompareArray(JSONArray expected, JSONArray source) {
		if (expected.length() != source.length())
			return false;

		for (int i = 0; i < expected.length(); i++) {
			boolean equivalent = false;
			JSONObject expectedIterator = expected.getJSONObject(i);
			for (int j = 0; j < source.length(); j++) {
				JSONObject sourceIterator = source.getJSONObject(j);
				// System.out.println("Comparing: " + i + "|" + expectedIterator
				// + " -> " + j + "|" + sourceIterator);
				if (deepCompareJSON(expectedIterator, sourceIterator)) {
					// System.out.println(true);
					equivalent = true;
				} else {
					// System.out.println(false);
				}
			}
			if (!equivalent) {
				return false;
			}
		}
		return true;
	}

	public static boolean deepCompareJSON(JSONObject expected, JSONObject source) {
		if (expected.length() != source.length())
			return false;
		
		for (String key : JSONObject.getNames(expected)) {
			if (source.has(key) && expected.get(key).equals(source.get(key))) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
