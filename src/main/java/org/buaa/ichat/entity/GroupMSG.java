package org.buaa.ichat.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
*
*  @author 
*/
public class GroupMSG implements Serializable {

    private static final long serialVersionUID = 1591299255553L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer GM_ID;

    /**
    * 
    * isNullAble:0
    */
    private Integer senderID;

    /**
    * 
    * isNullAble:0
    */
    private String content;

    /**
    * 
    * isNullAble:0,defaultVal:0
    */
    private Integer type;

    /**
    * 
    * isNullAble:0
    */
    private String time;


    public void setGM_ID(Integer GM_ID){this.GM_ID = GM_ID;}

    public Integer getGM_ID(){return this.GM_ID;}

    public void setSenderID(Integer senderID){this.senderID = senderID;}

    public Integer getSenderID(){return this.senderID;}

    public void setContent(String content){this.content = content;}

    public String getContent(){return this.content;}

    public void setType(Integer type){this.type = type;}

    public Integer getType(){return this.type;}

    public void setTime(String time){this.time = time;}

    public String getTime(){return this.time;}
    @Override
    public String toString() {
        return "GroupMSG{" +
                "GM_ID='" + GM_ID + '\'' +
                "senderID='" + senderID + '\'' +
                "content='" + content + '\'' +
                "type='" + type + '\'' +
                "time='" + time + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private GroupMSG set;

        private ConditionBuilder where;

        public UpdateBuilder set(GroupMSG set){
            this.set = set;
            return this;
        }

        public GroupMSG getSet(){
            return this.set;
        }

        public UpdateBuilder where(ConditionBuilder where){
            this.where = where;
            return this;
        }

        public ConditionBuilder getWhere(){
            return this.where;
        }

        public UpdateBuilder build(){
            return this;
        }
    }

    public static class QueryBuilder extends GroupMSG{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> GM_IDList;

        public List<Integer> getGM_IDList(){return this.GM_IDList;}

        private Integer GM_IDSt;

        private Integer GM_IDEd;

        public Integer getGM_IDSt(){return this.GM_IDSt;}

        public Integer getGM_IDEd(){return this.GM_IDEd;}

        private List<Integer> senderIDList;

        public List<Integer> getSenderIDList(){return this.senderIDList;}

        private Integer senderIDSt;

        private Integer senderIDEd;

        public Integer getSenderIDSt(){return this.senderIDSt;}

        public Integer getSenderIDEd(){return this.senderIDEd;}

        private List<String> contentList;

        public List<String> getContentList(){return this.contentList;}


        private List<String> fuzzyContent;

        public List<String> getFuzzyContent(){return this.fuzzyContent;}

        private List<String> rightFuzzyContent;

        public List<String> getRightFuzzyContent(){return this.rightFuzzyContent;}
        private List<Integer> typeList;

        public List<Integer> getTypeList(){return this.typeList;}

        private Integer typeSt;

        private Integer typeEd;

        public Integer getTypeSt(){return this.typeSt;}

        public Integer getTypeEd(){return this.typeEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder GM_IDBetWeen(Integer GM_IDSt,Integer GM_IDEd){
            this.GM_IDSt = GM_IDSt;
            this.GM_IDEd = GM_IDEd;
            return this;
        }

        public QueryBuilder GM_IDGreaterEqThan(Integer GM_IDSt){
            this.GM_IDSt = GM_IDSt;
            return this;
        }
        public QueryBuilder GM_IDLessEqThan(Integer GM_IDEd){
            this.GM_IDEd = GM_IDEd;
            return this;
        }


        public QueryBuilder GM_ID(Integer GM_ID){
            setGM_ID(GM_ID);
            return this;
        }

        public QueryBuilder GM_IDList(Integer ... GM_ID){
            this.GM_IDList = solveNullList(GM_ID);
            return this;
        }

        public QueryBuilder GM_IDList(List<Integer> GM_ID){
            this.GM_IDList = GM_ID;
            return this;
        }

        public QueryBuilder fetchGM_ID(){
            setFetchFields("fetchFields","GM_ID");
            return this;
        }

        public QueryBuilder excludeGM_ID(){
            setFetchFields("excludeFields","GM_ID");
            return this;
        }

        public QueryBuilder senderIDBetWeen(Integer senderIDSt,Integer senderIDEd){
            this.senderIDSt = senderIDSt;
            this.senderIDEd = senderIDEd;
            return this;
        }

        public QueryBuilder senderIDGreaterEqThan(Integer senderIDSt){
            this.senderIDSt = senderIDSt;
            return this;
        }
        public QueryBuilder senderIDLessEqThan(Integer senderIDEd){
            this.senderIDEd = senderIDEd;
            return this;
        }


        public QueryBuilder senderID(Integer senderID){
            setSenderID(senderID);
            return this;
        }

        public QueryBuilder senderIDList(Integer ... senderID){
            this.senderIDList = solveNullList(senderID);
            return this;
        }

        public QueryBuilder senderIDList(List<Integer> senderID){
            this.senderIDList = senderID;
            return this;
        }

        public QueryBuilder fetchSenderID(){
            setFetchFields("fetchFields","senderID");
            return this;
        }

        public QueryBuilder excludeSenderID(){
            setFetchFields("excludeFields","senderID");
            return this;
        }

        public QueryBuilder fuzzyContent (List<String> fuzzyContent){
            this.fuzzyContent = fuzzyContent;
            return this;
        }

        public QueryBuilder fuzzyContent (String ... fuzzyContent){
            this.fuzzyContent = solveNullList(fuzzyContent);
            return this;
        }

        public QueryBuilder rightFuzzyContent (List<String> rightFuzzyContent){
            this.rightFuzzyContent = rightFuzzyContent;
            return this;
        }

        public QueryBuilder rightFuzzyContent (String ... rightFuzzyContent){
            this.rightFuzzyContent = solveNullList(rightFuzzyContent);
            return this;
        }

        public QueryBuilder content(String content){
            setContent(content);
            return this;
        }

        public QueryBuilder contentList(String ... content){
            this.contentList = solveNullList(content);
            return this;
        }

        public QueryBuilder contentList(List<String> content){
            this.contentList = content;
            return this;
        }

        public QueryBuilder fetchContent(){
            setFetchFields("fetchFields","content");
            return this;
        }

        public QueryBuilder excludeContent(){
            setFetchFields("excludeFields","content");
            return this;
        }

        public QueryBuilder typeBetWeen(Integer typeSt,Integer typeEd){
            this.typeSt = typeSt;
            this.typeEd = typeEd;
            return this;
        }

        public QueryBuilder typeGreaterEqThan(Integer typeSt){
            this.typeSt = typeSt;
            return this;
        }
        public QueryBuilder typeLessEqThan(Integer typeEd){
            this.typeEd = typeEd;
            return this;
        }


        public QueryBuilder type(Integer type){
            setType(type);
            return this;
        }

        public QueryBuilder typeList(Integer ... type){
            this.typeList = solveNullList(type);
            return this;
        }

        public QueryBuilder typeList(List<Integer> type){
            this.typeList = type;
            return this;
        }

        public QueryBuilder fetchType(){
            setFetchFields("fetchFields","type");
            return this;
        }

        public QueryBuilder excludeType(){
            setFetchFields("excludeFields","type");
            return this;
        }

        public QueryBuilder fuzzyTime (List<String> fuzzyTime){
            this.fuzzyTime = fuzzyTime;
            return this;
        }

        public QueryBuilder fuzzyTime (String ... fuzzyTime){
            this.fuzzyTime = solveNullList(fuzzyTime);
            return this;
        }

        public QueryBuilder rightFuzzyTime (List<String> rightFuzzyTime){
            this.rightFuzzyTime = rightFuzzyTime;
            return this;
        }

        public QueryBuilder rightFuzzyTime (String ... rightFuzzyTime){
            this.rightFuzzyTime = solveNullList(rightFuzzyTime);
            return this;
        }

        public QueryBuilder time(String time){
            setTime(time);
            return this;
        }

        public QueryBuilder timeList(String ... time){
            this.timeList = solveNullList(time);
            return this;
        }

        public QueryBuilder timeList(List<String> time){
            this.timeList = time;
            return this;
        }

        public QueryBuilder fetchTime(){
            setFetchFields("fetchFields","time");
            return this;
        }

        public QueryBuilder excludeTime(){
            setFetchFields("excludeFields","time");
            return this;
        }
        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public QueryBuilder fetchAll(){
            this.fetchFields.put("AllFields",true);
            return this;
        }

        public QueryBuilder addField(String ... fields){
            List<String> list = new ArrayList<>();
            if (fields != null){
                for (String field : fields){
                    list.add(field);
                }
            }
            this.fetchFields.put("otherFields",list);
            return this;
        }
        @SuppressWarnings("unchecked")
        private void setFetchFields(String key,String val){
            Map<String,Boolean> fields= (Map<String, Boolean>) this.fetchFields.get(key);
            if (fields == null){
                fields = new HashMap<>();
            }
            fields.put(val,true);
            this.fetchFields.put(key,fields);
        }

        public GroupMSG build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> GM_IDList;

        public List<Integer> getGM_IDList(){return this.GM_IDList;}

        private Integer GM_IDSt;

        private Integer GM_IDEd;

        public Integer getGM_IDSt(){return this.GM_IDSt;}

        public Integer getGM_IDEd(){return this.GM_IDEd;}

        private List<Integer> senderIDList;

        public List<Integer> getSenderIDList(){return this.senderIDList;}

        private Integer senderIDSt;

        private Integer senderIDEd;

        public Integer getSenderIDSt(){return this.senderIDSt;}

        public Integer getSenderIDEd(){return this.senderIDEd;}

        private List<String> contentList;

        public List<String> getContentList(){return this.contentList;}


        private List<String> fuzzyContent;

        public List<String> getFuzzyContent(){return this.fuzzyContent;}

        private List<String> rightFuzzyContent;

        public List<String> getRightFuzzyContent(){return this.rightFuzzyContent;}
        private List<Integer> typeList;

        public List<Integer> getTypeList(){return this.typeList;}

        private Integer typeSt;

        private Integer typeEd;

        public Integer getTypeSt(){return this.typeSt;}

        public Integer getTypeEd(){return this.typeEd;}

        private List<String> timeList;

        public List<String> getTimeList(){return this.timeList;}


        private List<String> fuzzyTime;

        public List<String> getFuzzyTime(){return this.fuzzyTime;}

        private List<String> rightFuzzyTime;

        public List<String> getRightFuzzyTime(){return this.rightFuzzyTime;}

        public ConditionBuilder GM_IDBetWeen(Integer GM_IDSt,Integer GM_IDEd){
            this.GM_IDSt = GM_IDSt;
            this.GM_IDEd = GM_IDEd;
            return this;
        }

        public ConditionBuilder GM_IDGreaterEqThan(Integer GM_IDSt){
            this.GM_IDSt = GM_IDSt;
            return this;
        }
        public ConditionBuilder GM_IDLessEqThan(Integer GM_IDEd){
            this.GM_IDEd = GM_IDEd;
            return this;
        }


        public ConditionBuilder GM_IDList(Integer ... GM_ID){
            this.GM_IDList = solveNullList(GM_ID);
            return this;
        }

        public ConditionBuilder GM_IDList(List<Integer> GM_ID){
            this.GM_IDList = GM_ID;
            return this;
        }

        public ConditionBuilder senderIDBetWeen(Integer senderIDSt,Integer senderIDEd){
            this.senderIDSt = senderIDSt;
            this.senderIDEd = senderIDEd;
            return this;
        }

        public ConditionBuilder senderIDGreaterEqThan(Integer senderIDSt){
            this.senderIDSt = senderIDSt;
            return this;
        }
        public ConditionBuilder senderIDLessEqThan(Integer senderIDEd){
            this.senderIDEd = senderIDEd;
            return this;
        }


        public ConditionBuilder senderIDList(Integer ... senderID){
            this.senderIDList = solveNullList(senderID);
            return this;
        }

        public ConditionBuilder senderIDList(List<Integer> senderID){
            this.senderIDList = senderID;
            return this;
        }

        public ConditionBuilder fuzzyContent (List<String> fuzzyContent){
            this.fuzzyContent = fuzzyContent;
            return this;
        }

        public ConditionBuilder fuzzyContent (String ... fuzzyContent){
            this.fuzzyContent = solveNullList(fuzzyContent);
            return this;
        }

        public ConditionBuilder rightFuzzyContent (List<String> rightFuzzyContent){
            this.rightFuzzyContent = rightFuzzyContent;
            return this;
        }

        public ConditionBuilder rightFuzzyContent (String ... rightFuzzyContent){
            this.rightFuzzyContent = solveNullList(rightFuzzyContent);
            return this;
        }

        public ConditionBuilder contentList(String ... content){
            this.contentList = solveNullList(content);
            return this;
        }

        public ConditionBuilder contentList(List<String> content){
            this.contentList = content;
            return this;
        }

        public ConditionBuilder typeBetWeen(Integer typeSt,Integer typeEd){
            this.typeSt = typeSt;
            this.typeEd = typeEd;
            return this;
        }

        public ConditionBuilder typeGreaterEqThan(Integer typeSt){
            this.typeSt = typeSt;
            return this;
        }
        public ConditionBuilder typeLessEqThan(Integer typeEd){
            this.typeEd = typeEd;
            return this;
        }


        public ConditionBuilder typeList(Integer ... type){
            this.typeList = solveNullList(type);
            return this;
        }

        public ConditionBuilder typeList(List<Integer> type){
            this.typeList = type;
            return this;
        }

        public ConditionBuilder fuzzyTime (List<String> fuzzyTime){
            this.fuzzyTime = fuzzyTime;
            return this;
        }

        public ConditionBuilder fuzzyTime (String ... fuzzyTime){
            this.fuzzyTime = solveNullList(fuzzyTime);
            return this;
        }

        public ConditionBuilder rightFuzzyTime (List<String> rightFuzzyTime){
            this.rightFuzzyTime = rightFuzzyTime;
            return this;
        }

        public ConditionBuilder rightFuzzyTime (String ... rightFuzzyTime){
            this.rightFuzzyTime = solveNullList(rightFuzzyTime);
            return this;
        }

        public ConditionBuilder timeList(String ... time){
            this.timeList = solveNullList(time);
            return this;
        }

        public ConditionBuilder timeList(List<String> time){
            this.timeList = time;
            return this;
        }

        private <T>List<T> solveNullList(T ... objs){
            if (objs != null){
            List<T> list = new ArrayList<>();
                for (T item : objs){
                    if (item != null){
                        list.add(item);
                    }
                }
                return list;
            }
            return null;
        }

        public ConditionBuilder build(){return this;}
    }

    public static class Builder {

        private GroupMSG obj;

        public Builder(){
            this.obj = new GroupMSG();
        }

        public Builder GM_ID(Integer GM_ID){
            this.obj.setGM_ID(GM_ID);
            return this;
        }
        public Builder senderID(Integer senderID){
            this.obj.setSenderID(senderID);
            return this;
        }
        public Builder content(String content){
            this.obj.setContent(content);
            return this;
        }
        public Builder type(Integer type){
            this.obj.setType(type);
            return this;
        }
        public Builder time(String time){
            this.obj.setTime(time);
            return this;
        }
        public GroupMSG build(){return obj;}
    }

}
