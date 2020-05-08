package com.yj.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class GsonUtil {

	static Gson gson=new GsonBuilder().serializeNulls().registerTypeAdapter(Double.class, new JsonSerializer<Double>() {
		public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
			if (src == src.longValue())
				return new JsonPrimitive(src.longValue());
			return new JsonPrimitive(src);
		}
	}).create();
	/*public static void main(String[] args) {
		String json="[{\"id\":40,\"arch_no\":\"20101230007\",\"checkdate\":\"\\/Date(1293638400000)\\/\",\"height\":155,\"weight\":70,\"sp\":160,\"dp\":94,\"sp_lie\":0,\"dp_lie\":0,\"bmemo\":\"\",\"bei\":0,\"T1\":0,\"T2\":0,\"Tbc\":0,\"Tmbb\":0,\"Tfbb\":0,\"bc\":0,\"be1\":0,\"bf\":0,\"mn\":0,\"dt\":0,\"dwmch\":\"\",\"xgdy\":0,\"ncom\":1,\"pr\":0,\"sv\":0,\"co\":0,\"si\":0,\"ci\":0,\"vpe\":0,\"ewk\":0,\"hoi\":0,\"hov\":0,\"lvwi\":0,\"cmbr\":0,\"cmbv\":0,\"cmbn\":0,\"svr\":0,\"rsvr\":0,\"pp\":0,\"msp\":0,\"mdp\":0,\"map\":0,\"ac\":0,\"ccp\":0,\"blk\":0,\"fek\":0,\"tpr\":0,\"spr\":0,\"ver\":0,\"pawp\":0,\"par\":0,\"pap\":0,\"bv\":0,\"nn\":0,\"nr\":0,\"mhr\":0,\"mrt\":0,\"mst\":0,\"diag\":\"\",\"baseimpedance\":0,\"poledistance\":0,\"touyun\":0,\"toutong\":0,\"mianhong\":0,\"muchi\":0,\"jizao\":0,\"kougan\":1,\"kouku\":1,\"bianmi\":0,\"souchi\":0,\"pifa\":1,\"xinji\":1,\"muse\":0,\"erming\":0,\"zihan\":0,\"miansebai\":0,\"hunhua\":0,\"yaosuantuiruan\":0,\"jintirourun\":0,\"shimian\":1,\"oututanxian\":0,\"koudanshishao\":0,\"xinfan\":0,\"huaxie\":0,\"janwang\":0,\"fanre\":0,\"touzhongjiaoqing\":0,\"quanshenbushi\":0,\"mianbuchaohong\":0,\"hongre\":0,\"paleng\":0,\"touzhongruguo\":0,\"xiongmen\":0,\"shuizhong\":0,\"zhimapiantan\":1,\"taibai\":0,\"honghuang\":0,\"pangni\":1,\"honggan\":0,\"shaotai\":0,\"shedanwujin\":1,\"shean\":0,\"sheyu\":0,\"xianshu\":0,\"xianxi\":0,\"xixian\":1,\"maihua\":0,\"chenxi\":0,\"maichen\":0,\"yinjiushi\":0,\"jinzhang\":0,\"tilishao\":0,\"caixian\":0,\"jizaoyouyu\":0,\"huanjingnao\":0,\"tangniaogaozhi\":0,\"guanxinnaoxue\":0,\"zuzhongdrugDpH\":0,\"drugDPH\":0,\"drugSPH\":0,\"stopDPH\":0,\"stopSPDPH\":0,\"stopSPH\":0,\"noH\":0,\"zhongdiagi\":42,\"zhongdiag\":\"痰浊壅盛证+气虚血瘀证\",\"xidiagi\":-1,\"xidiag\":\"\",\"channel1\":\"\",\"channel2\":\"\",\"channel3\":\"\",\"channel4\":\"\",\"advice\":\"\",\"drugadvice\":\"\",\"ecg_I\":\"\",\"ecg_II\":\"\",\"ecg_III\":\"\",\"ecg_avR\":\"\",\"ecg_avL\":\"\",\"ecg_avF\":\"\",\"ecg_V\":\"\",\"ecg_resp\":\"\",\"wangdiag\":2,\"chengdiag\":2}]";
		System.out.println(GsonUtil.gsonToList(json));
	}*/
	static Type mapType =new TypeToken<HashMap<String, Object>>() {}.getType();

	static Type listType =new TypeToken<List<HashMap<String, Object>>>() {}.getType();

	static Type listType2 =new TypeToken<List<String>>() {}.getType();

	public static HashMap<String,Object> gsonToMap(String json){
		return gson.fromJson(json,mapType);
	}
	public static List<HashMap<String,Object>> gsonToList(String json){
		List<HashMap<String,Object>> list = gson.fromJson(json,listType);
		List<HashMap<String,Object>> resultList=new ArrayList<HashMap<String,Object>>();
		list.forEach(row->{
			Set<String> set = row.keySet();
			HashMap<String,Object> r=new HashMap<>();
			for(String key:set) {
				Object value = row.get(key);
				if(value instanceof Double) {
					if(((Double)value).longValue()==(Double)value) {
						row.put(key,((Double)value).longValue());
					}
				}
				r.put(key, value);
				r.put(key.toLowerCase(), value);
			}
			resultList.add(r);
		});
		return resultList;
	}
	public static List<String> gsonToList2(String json){
		return gson.fromJson(json,listType2);
	}

	public static String objectToJson(Object obj) {
		return gson.toJson(obj);
	}
}
