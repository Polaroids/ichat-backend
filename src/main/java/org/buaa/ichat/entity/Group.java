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
public class Group implements Serializable {

    private static final long serialVersionUID = 1590646439546L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer groupID;

    /**
    * 
    * isNullAble:0
    */
    private String createTime;

    /**
    * 
    * isNullAble:0
    */
    private Integer owner;

    /**
    * 
    * isNullAble:0
    */
    private String name;

    /**
    * 
    * isNullAble:1
    */
    private String avatar;

    /**
    * 
    * isNullAble:1
    */
    private String description;


    public void setGroupID(Integer groupID){this.groupID = groupID;}

    public Integer getGroupID(){return this.groupID;}

    public void setCreateTime(String createTime){this.createTime = createTime;}

    public String getCreateTime(){return this.createTime;}

    public void setOwner(Integer owner){this.owner = owner;}

    public Integer getOwner(){return this.owner;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setAvatar(String avatar){this.avatar = avatar;}

    public String getAvatar(){return this.avatar;}

    public void setDescription(String description){this.description = description;}

    public String getDescription(){return this.description;}
    @Override
    public String toString() {
        return "Group{" +
                "groupID='" + groupID + '\'' +
                "createTime='" + createTime + '\'' +
                "owner='" + owner + '\'' +
                "name='" + name + '\'' +
                "avatar='" + avatar + '\'' +
                "description='" + description + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private Group set;

        private ConditionBuilder where;

        public UpdateBuilder set(Group set){
            this.set = set;
            return this;
        }

        public Group getSet(){
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

    public static class QueryBuilder extends Group{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> groupIDList;

        public List<Integer> getGroupIDList(){return this.groupIDList;}

        private Integer groupIDSt;

        private Integer groupIDEd;

        public Integer getGroupIDSt(){return this.groupIDSt;}

        public Integer getGroupIDEd(){return this.groupIDEd;}

        private List<String> createTimeList;

        public List<String> getCreateTimeList(){return this.createTimeList;}


        private List<String> fuzzyCreateTime;

        public List<String> getFuzzyCreateTime(){return this.fuzzyCreateTime;}

        private List<String> rightFuzzyCreateTime;

        public List<String> getRightFuzzyCreateTime(){return this.rightFuzzyCreateTime;}
        private List<Integer> ownerList;

        public List<Integer> getOwnerList(){return this.ownerList;}

        private Integer ownerSt;

        private Integer ownerEd;

        public Integer getOwnerSt(){return this.ownerSt;}

        public Integer getOwnerEd(){return this.ownerEd;}

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<String> avatarList;

        public List<String> getAvatarList(){return this.avatarList;}


        private List<String> fuzzyAvatar;

        public List<String> getFuzzyAvatar(){return this.fuzzyAvatar;}

        private List<String> rightFuzzyAvatar;

        public List<String> getRightFuzzyAvatar(){return this.rightFuzzyAvatar;}
        private List<String> descriptionList;

        public List<String> getDescriptionList(){return this.descriptionList;}


        private List<String> fuzzyDescription;

        public List<String> getFuzzyDescription(){return this.fuzzyDescription;}

        private List<String> rightFuzzyDescription;

        public List<String> getRightFuzzyDescription(){return this.rightFuzzyDescription;}
        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder groupIDBetWeen(Integer groupIDSt,Integer groupIDEd){
            this.groupIDSt = groupIDSt;
            this.groupIDEd = groupIDEd;
            return this;
        }

        public QueryBuilder groupIDGreaterEqThan(Integer groupIDSt){
            this.groupIDSt = groupIDSt;
            return this;
        }
        public QueryBuilder groupIDLessEqThan(Integer groupIDEd){
            this.groupIDEd = groupIDEd;
            return this;
        }


        public QueryBuilder groupID(Integer groupID){
            setGroupID(groupID);
            return this;
        }

        public QueryBuilder groupIDList(Integer ... groupID){
            this.groupIDList = solveNullList(groupID);
            return this;
        }

        public QueryBuilder groupIDList(List<Integer> groupID){
            this.groupIDList = groupID;
            return this;
        }

        public QueryBuilder fetchGroupID(){
            setFetchFields("fetchFields","groupID");
            return this;
        }

        public QueryBuilder excludeGroupID(){
            setFetchFields("excludeFields","groupID");
            return this;
        }

        public QueryBuilder fuzzyCreateTime (List<String> fuzzyCreateTime){
            this.fuzzyCreateTime = fuzzyCreateTime;
            return this;
        }

        public QueryBuilder fuzzyCreateTime (String ... fuzzyCreateTime){
            this.fuzzyCreateTime = solveNullList(fuzzyCreateTime);
            return this;
        }

        public QueryBuilder rightFuzzyCreateTime (List<String> rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = rightFuzzyCreateTime;
            return this;
        }

        public QueryBuilder rightFuzzyCreateTime (String ... rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = solveNullList(rightFuzzyCreateTime);
            return this;
        }

        public QueryBuilder createTime(String createTime){
            setCreateTime(createTime);
            return this;
        }

        public QueryBuilder createTimeList(String ... createTime){
            this.createTimeList = solveNullList(createTime);
            return this;
        }

        public QueryBuilder createTimeList(List<String> createTime){
            this.createTimeList = createTime;
            return this;
        }

        public QueryBuilder fetchCreateTime(){
            setFetchFields("fetchFields","createTime");
            return this;
        }

        public QueryBuilder excludeCreateTime(){
            setFetchFields("excludeFields","createTime");
            return this;
        }

        public QueryBuilder ownerBetWeen(Integer ownerSt,Integer ownerEd){
            this.ownerSt = ownerSt;
            this.ownerEd = ownerEd;
            return this;
        }

        public QueryBuilder ownerGreaterEqThan(Integer ownerSt){
            this.ownerSt = ownerSt;
            return this;
        }
        public QueryBuilder ownerLessEqThan(Integer ownerEd){
            this.ownerEd = ownerEd;
            return this;
        }


        public QueryBuilder owner(Integer owner){
            setOwner(owner);
            return this;
        }

        public QueryBuilder ownerList(Integer ... owner){
            this.ownerList = solveNullList(owner);
            return this;
        }

        public QueryBuilder ownerList(List<Integer> owner){
            this.ownerList = owner;
            return this;
        }

        public QueryBuilder fetchOwner(){
            setFetchFields("fetchFields","owner");
            return this;
        }

        public QueryBuilder excludeOwner(){
            setFetchFields("excludeFields","owner");
            return this;
        }

        public QueryBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public QueryBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public QueryBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public QueryBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public QueryBuilder name(String name){
            setName(name);
            return this;
        }

        public QueryBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public QueryBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public QueryBuilder fetchName(){
            setFetchFields("fetchFields","name");
            return this;
        }

        public QueryBuilder excludeName(){
            setFetchFields("excludeFields","name");
            return this;
        }

        public QueryBuilder fuzzyAvatar (List<String> fuzzyAvatar){
            this.fuzzyAvatar = fuzzyAvatar;
            return this;
        }

        public QueryBuilder fuzzyAvatar (String ... fuzzyAvatar){
            this.fuzzyAvatar = solveNullList(fuzzyAvatar);
            return this;
        }

        public QueryBuilder rightFuzzyAvatar (List<String> rightFuzzyAvatar){
            this.rightFuzzyAvatar = rightFuzzyAvatar;
            return this;
        }

        public QueryBuilder rightFuzzyAvatar (String ... rightFuzzyAvatar){
            this.rightFuzzyAvatar = solveNullList(rightFuzzyAvatar);
            return this;
        }

        public QueryBuilder avatar(String avatar){
            setAvatar(avatar);
            return this;
        }

        public QueryBuilder avatarList(String ... avatar){
            this.avatarList = solveNullList(avatar);
            return this;
        }

        public QueryBuilder avatarList(List<String> avatar){
            this.avatarList = avatar;
            return this;
        }

        public QueryBuilder fetchAvatar(){
            setFetchFields("fetchFields","avatar");
            return this;
        }

        public QueryBuilder excludeAvatar(){
            setFetchFields("excludeFields","avatar");
            return this;
        }

        public QueryBuilder fuzzyDescription (List<String> fuzzyDescription){
            this.fuzzyDescription = fuzzyDescription;
            return this;
        }

        public QueryBuilder fuzzyDescription (String ... fuzzyDescription){
            this.fuzzyDescription = solveNullList(fuzzyDescription);
            return this;
        }

        public QueryBuilder rightFuzzyDescription (List<String> rightFuzzyDescription){
            this.rightFuzzyDescription = rightFuzzyDescription;
            return this;
        }

        public QueryBuilder rightFuzzyDescription (String ... rightFuzzyDescription){
            this.rightFuzzyDescription = solveNullList(rightFuzzyDescription);
            return this;
        }

        public QueryBuilder description(String description){
            setDescription(description);
            return this;
        }

        public QueryBuilder descriptionList(String ... description){
            this.descriptionList = solveNullList(description);
            return this;
        }

        public QueryBuilder descriptionList(List<String> description){
            this.descriptionList = description;
            return this;
        }

        public QueryBuilder fetchDescription(){
            setFetchFields("fetchFields","description");
            return this;
        }

        public QueryBuilder excludeDescription(){
            setFetchFields("excludeFields","description");
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

        public Group build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> groupIDList;

        public List<Integer> getGroupIDList(){return this.groupIDList;}

        private Integer groupIDSt;

        private Integer groupIDEd;

        public Integer getGroupIDSt(){return this.groupIDSt;}

        public Integer getGroupIDEd(){return this.groupIDEd;}

        private List<String> createTimeList;

        public List<String> getCreateTimeList(){return this.createTimeList;}


        private List<String> fuzzyCreateTime;

        public List<String> getFuzzyCreateTime(){return this.fuzzyCreateTime;}

        private List<String> rightFuzzyCreateTime;

        public List<String> getRightFuzzyCreateTime(){return this.rightFuzzyCreateTime;}
        private List<Integer> ownerList;

        public List<Integer> getOwnerList(){return this.ownerList;}

        private Integer ownerSt;

        private Integer ownerEd;

        public Integer getOwnerSt(){return this.ownerSt;}

        public Integer getOwnerEd(){return this.ownerEd;}

        private List<String> nameList;

        public List<String> getNameList(){return this.nameList;}


        private List<String> fuzzyName;

        public List<String> getFuzzyName(){return this.fuzzyName;}

        private List<String> rightFuzzyName;

        public List<String> getRightFuzzyName(){return this.rightFuzzyName;}
        private List<String> avatarList;

        public List<String> getAvatarList(){return this.avatarList;}


        private List<String> fuzzyAvatar;

        public List<String> getFuzzyAvatar(){return this.fuzzyAvatar;}

        private List<String> rightFuzzyAvatar;

        public List<String> getRightFuzzyAvatar(){return this.rightFuzzyAvatar;}
        private List<String> descriptionList;

        public List<String> getDescriptionList(){return this.descriptionList;}


        private List<String> fuzzyDescription;

        public List<String> getFuzzyDescription(){return this.fuzzyDescription;}

        private List<String> rightFuzzyDescription;

        public List<String> getRightFuzzyDescription(){return this.rightFuzzyDescription;}

        public ConditionBuilder groupIDBetWeen(Integer groupIDSt,Integer groupIDEd){
            this.groupIDSt = groupIDSt;
            this.groupIDEd = groupIDEd;
            return this;
        }

        public ConditionBuilder groupIDGreaterEqThan(Integer groupIDSt){
            this.groupIDSt = groupIDSt;
            return this;
        }
        public ConditionBuilder groupIDLessEqThan(Integer groupIDEd){
            this.groupIDEd = groupIDEd;
            return this;
        }


        public ConditionBuilder groupIDList(Integer ... groupID){
            this.groupIDList = solveNullList(groupID);
            return this;
        }

        public ConditionBuilder groupIDList(List<Integer> groupID){
            this.groupIDList = groupID;
            return this;
        }

        public ConditionBuilder fuzzyCreateTime (List<String> fuzzyCreateTime){
            this.fuzzyCreateTime = fuzzyCreateTime;
            return this;
        }

        public ConditionBuilder fuzzyCreateTime (String ... fuzzyCreateTime){
            this.fuzzyCreateTime = solveNullList(fuzzyCreateTime);
            return this;
        }

        public ConditionBuilder rightFuzzyCreateTime (List<String> rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = rightFuzzyCreateTime;
            return this;
        }

        public ConditionBuilder rightFuzzyCreateTime (String ... rightFuzzyCreateTime){
            this.rightFuzzyCreateTime = solveNullList(rightFuzzyCreateTime);
            return this;
        }

        public ConditionBuilder createTimeList(String ... createTime){
            this.createTimeList = solveNullList(createTime);
            return this;
        }

        public ConditionBuilder createTimeList(List<String> createTime){
            this.createTimeList = createTime;
            return this;
        }

        public ConditionBuilder ownerBetWeen(Integer ownerSt,Integer ownerEd){
            this.ownerSt = ownerSt;
            this.ownerEd = ownerEd;
            return this;
        }

        public ConditionBuilder ownerGreaterEqThan(Integer ownerSt){
            this.ownerSt = ownerSt;
            return this;
        }
        public ConditionBuilder ownerLessEqThan(Integer ownerEd){
            this.ownerEd = ownerEd;
            return this;
        }


        public ConditionBuilder ownerList(Integer ... owner){
            this.ownerList = solveNullList(owner);
            return this;
        }

        public ConditionBuilder ownerList(List<Integer> owner){
            this.ownerList = owner;
            return this;
        }

        public ConditionBuilder fuzzyName (List<String> fuzzyName){
            this.fuzzyName = fuzzyName;
            return this;
        }

        public ConditionBuilder fuzzyName (String ... fuzzyName){
            this.fuzzyName = solveNullList(fuzzyName);
            return this;
        }

        public ConditionBuilder rightFuzzyName (List<String> rightFuzzyName){
            this.rightFuzzyName = rightFuzzyName;
            return this;
        }

        public ConditionBuilder rightFuzzyName (String ... rightFuzzyName){
            this.rightFuzzyName = solveNullList(rightFuzzyName);
            return this;
        }

        public ConditionBuilder nameList(String ... name){
            this.nameList = solveNullList(name);
            return this;
        }

        public ConditionBuilder nameList(List<String> name){
            this.nameList = name;
            return this;
        }

        public ConditionBuilder fuzzyAvatar (List<String> fuzzyAvatar){
            this.fuzzyAvatar = fuzzyAvatar;
            return this;
        }

        public ConditionBuilder fuzzyAvatar (String ... fuzzyAvatar){
            this.fuzzyAvatar = solveNullList(fuzzyAvatar);
            return this;
        }

        public ConditionBuilder rightFuzzyAvatar (List<String> rightFuzzyAvatar){
            this.rightFuzzyAvatar = rightFuzzyAvatar;
            return this;
        }

        public ConditionBuilder rightFuzzyAvatar (String ... rightFuzzyAvatar){
            this.rightFuzzyAvatar = solveNullList(rightFuzzyAvatar);
            return this;
        }

        public ConditionBuilder avatarList(String ... avatar){
            this.avatarList = solveNullList(avatar);
            return this;
        }

        public ConditionBuilder avatarList(List<String> avatar){
            this.avatarList = avatar;
            return this;
        }

        public ConditionBuilder fuzzyDescription (List<String> fuzzyDescription){
            this.fuzzyDescription = fuzzyDescription;
            return this;
        }

        public ConditionBuilder fuzzyDescription (String ... fuzzyDescription){
            this.fuzzyDescription = solveNullList(fuzzyDescription);
            return this;
        }

        public ConditionBuilder rightFuzzyDescription (List<String> rightFuzzyDescription){
            this.rightFuzzyDescription = rightFuzzyDescription;
            return this;
        }

        public ConditionBuilder rightFuzzyDescription (String ... rightFuzzyDescription){
            this.rightFuzzyDescription = solveNullList(rightFuzzyDescription);
            return this;
        }

        public ConditionBuilder descriptionList(String ... description){
            this.descriptionList = solveNullList(description);
            return this;
        }

        public ConditionBuilder descriptionList(List<String> description){
            this.descriptionList = description;
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

        private Group obj;

        public Builder(){
            this.obj = new Group();
        }

        public Builder groupID(Integer groupID){
            this.obj.setGroupID(groupID);
            return this;
        }
        public Builder createTime(String createTime){
            this.obj.setCreateTime(createTime);
            return this;
        }
        public Builder owner(Integer owner){
            this.obj.setOwner(owner);
            return this;
        }
        public Builder name(String name){
            this.obj.setName(name);
            return this;
        }
        public Builder avatar(String avatar){
            this.obj.setAvatar(avatar);
            return this;
        }
        public Builder description(String description){
            this.obj.setDescription(description);
            return this;
        }
        public Group build(){return obj;}
    }

}
