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
public class GroupFile implements Serializable {

    private static final long serialVersionUID = 1591290482594L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer fileID;

    /**
    * 
    * isNullAble:0
    */
    private String fileName;

    /**
    * 
    * isNullAble:0
    */
    private String fileUrl;

    /**
    * 
    * isNullAble:0
    */
    private String uploadTime;

    /**
    * 
    * isNullAble:0
    */
    private Integer uploadGroupID;

    /**
    * 
    * isNullAble:0
    */
    private Integer uploadUserID;


    public void setFileID(Integer fileID){this.fileID = fileID;}

    public Integer getFileID(){return this.fileID;}

    public void setFileName(String fileName){this.fileName = fileName;}

    public String getFileName(){return this.fileName;}

    public void setFileUrl(String fileUrl){this.fileUrl = fileUrl;}

    public String getFileUrl(){return this.fileUrl;}

    public void setUploadTime(String uploadTime){this.uploadTime = uploadTime;}

    public String getUploadTime(){return this.uploadTime;}

    public void setUploadGroupID(Integer uploadGroupID){this.uploadGroupID = uploadGroupID;}

    public Integer getUploadGroupID(){return this.uploadGroupID;}

    public void setUploadUserID(Integer uploadUserID){this.uploadUserID = uploadUserID;}

    public Integer getUploadUserID(){return this.uploadUserID;}
    @Override
    public String toString() {
        return "GroupFile{" +
                "fileID='" + fileID + '\'' +
                "fileName='" + fileName + '\'' +
                "fileUrl='" + fileUrl + '\'' +
                "uploadTime='" + uploadTime + '\'' +
                "uploadGroupID='" + uploadGroupID + '\'' +
                "uploadUserID='" + uploadUserID + '\'' +
            '}';
    }

    public static Builder Build(){return new Builder();}

    public static ConditionBuilder ConditionBuild(){return new ConditionBuilder();}

    public static UpdateBuilder UpdateBuild(){return new UpdateBuilder();}

    public static QueryBuilder QueryBuild(){return new QueryBuilder();}

    public static class UpdateBuilder {

        private GroupFile set;

        private ConditionBuilder where;

        public UpdateBuilder set(GroupFile set){
            this.set = set;
            return this;
        }

        public GroupFile getSet(){
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

    public static class QueryBuilder extends GroupFile{
        /**
        * 需要返回的列
        */
        private Map<String,Object> fetchFields;

        public Map<String,Object> getFetchFields(){return this.fetchFields;}

        private List<Integer> fileIDList;

        public List<Integer> getFileIDList(){return this.fileIDList;}

        private Integer fileIDSt;

        private Integer fileIDEd;

        public Integer getFileIDSt(){return this.fileIDSt;}

        public Integer getFileIDEd(){return this.fileIDEd;}

        private List<String> fileNameList;

        public List<String> getFileNameList(){return this.fileNameList;}


        private List<String> fuzzyFileName;

        public List<String> getFuzzyFileName(){return this.fuzzyFileName;}

        private List<String> rightFuzzyFileName;

        public List<String> getRightFuzzyFileName(){return this.rightFuzzyFileName;}
        private List<String> fileUrlList;

        public List<String> getFileUrlList(){return this.fileUrlList;}


        private List<String> fuzzyFileUrl;

        public List<String> getFuzzyFileUrl(){return this.fuzzyFileUrl;}

        private List<String> rightFuzzyFileUrl;

        public List<String> getRightFuzzyFileUrl(){return this.rightFuzzyFileUrl;}
        private List<String> uploadTimeList;

        public List<String> getUploadTimeList(){return this.uploadTimeList;}


        private List<String> fuzzyUploadTime;

        public List<String> getFuzzyUploadTime(){return this.fuzzyUploadTime;}

        private List<String> rightFuzzyUploadTime;

        public List<String> getRightFuzzyUploadTime(){return this.rightFuzzyUploadTime;}
        private List<Integer> uploadGroupIDList;

        public List<Integer> getUploadGroupIDList(){return this.uploadGroupIDList;}

        private Integer uploadGroupIDSt;

        private Integer uploadGroupIDEd;

        public Integer getUploadGroupIDSt(){return this.uploadGroupIDSt;}

        public Integer getUploadGroupIDEd(){return this.uploadGroupIDEd;}

        private List<Integer> uploadUserIDList;

        public List<Integer> getUploadUserIDList(){return this.uploadUserIDList;}

        private Integer uploadUserIDSt;

        private Integer uploadUserIDEd;

        public Integer getUploadUserIDSt(){return this.uploadUserIDSt;}

        public Integer getUploadUserIDEd(){return this.uploadUserIDEd;}

        private QueryBuilder (){
            this.fetchFields = new HashMap<>();
        }

        public QueryBuilder fileIDBetWeen(Integer fileIDSt,Integer fileIDEd){
            this.fileIDSt = fileIDSt;
            this.fileIDEd = fileIDEd;
            return this;
        }

        public QueryBuilder fileIDGreaterEqThan(Integer fileIDSt){
            this.fileIDSt = fileIDSt;
            return this;
        }
        public QueryBuilder fileIDLessEqThan(Integer fileIDEd){
            this.fileIDEd = fileIDEd;
            return this;
        }


        public QueryBuilder fileID(Integer fileID){
            setFileID(fileID);
            return this;
        }

        public QueryBuilder fileIDList(Integer ... fileID){
            this.fileIDList = solveNullList(fileID);
            return this;
        }

        public QueryBuilder fileIDList(List<Integer> fileID){
            this.fileIDList = fileID;
            return this;
        }

        public QueryBuilder fetchFileID(){
            setFetchFields("fetchFields","fileID");
            return this;
        }

        public QueryBuilder excludeFileID(){
            setFetchFields("excludeFields","fileID");
            return this;
        }

        public QueryBuilder fuzzyFileName (List<String> fuzzyFileName){
            this.fuzzyFileName = fuzzyFileName;
            return this;
        }

        public QueryBuilder fuzzyFileName (String ... fuzzyFileName){
            this.fuzzyFileName = solveNullList(fuzzyFileName);
            return this;
        }

        public QueryBuilder rightFuzzyFileName (List<String> rightFuzzyFileName){
            this.rightFuzzyFileName = rightFuzzyFileName;
            return this;
        }

        public QueryBuilder rightFuzzyFileName (String ... rightFuzzyFileName){
            this.rightFuzzyFileName = solveNullList(rightFuzzyFileName);
            return this;
        }

        public QueryBuilder fileName(String fileName){
            setFileName(fileName);
            return this;
        }

        public QueryBuilder fileNameList(String ... fileName){
            this.fileNameList = solveNullList(fileName);
            return this;
        }

        public QueryBuilder fileNameList(List<String> fileName){
            this.fileNameList = fileName;
            return this;
        }

        public QueryBuilder fetchFileName(){
            setFetchFields("fetchFields","fileName");
            return this;
        }

        public QueryBuilder excludeFileName(){
            setFetchFields("excludeFields","fileName");
            return this;
        }

        public QueryBuilder fuzzyFileUrl (List<String> fuzzyFileUrl){
            this.fuzzyFileUrl = fuzzyFileUrl;
            return this;
        }

        public QueryBuilder fuzzyFileUrl (String ... fuzzyFileUrl){
            this.fuzzyFileUrl = solveNullList(fuzzyFileUrl);
            return this;
        }

        public QueryBuilder rightFuzzyFileUrl (List<String> rightFuzzyFileUrl){
            this.rightFuzzyFileUrl = rightFuzzyFileUrl;
            return this;
        }

        public QueryBuilder rightFuzzyFileUrl (String ... rightFuzzyFileUrl){
            this.rightFuzzyFileUrl = solveNullList(rightFuzzyFileUrl);
            return this;
        }

        public QueryBuilder fileUrl(String fileUrl){
            setFileUrl(fileUrl);
            return this;
        }

        public QueryBuilder fileUrlList(String ... fileUrl){
            this.fileUrlList = solveNullList(fileUrl);
            return this;
        }

        public QueryBuilder fileUrlList(List<String> fileUrl){
            this.fileUrlList = fileUrl;
            return this;
        }

        public QueryBuilder fetchFileUrl(){
            setFetchFields("fetchFields","fileUrl");
            return this;
        }

        public QueryBuilder excludeFileUrl(){
            setFetchFields("excludeFields","fileUrl");
            return this;
        }

        public QueryBuilder fuzzyUploadTime (List<String> fuzzyUploadTime){
            this.fuzzyUploadTime = fuzzyUploadTime;
            return this;
        }

        public QueryBuilder fuzzyUploadTime (String ... fuzzyUploadTime){
            this.fuzzyUploadTime = solveNullList(fuzzyUploadTime);
            return this;
        }

        public QueryBuilder rightFuzzyUploadTime (List<String> rightFuzzyUploadTime){
            this.rightFuzzyUploadTime = rightFuzzyUploadTime;
            return this;
        }

        public QueryBuilder rightFuzzyUploadTime (String ... rightFuzzyUploadTime){
            this.rightFuzzyUploadTime = solveNullList(rightFuzzyUploadTime);
            return this;
        }

        public QueryBuilder uploadTime(String uploadTime){
            setUploadTime(uploadTime);
            return this;
        }

        public QueryBuilder uploadTimeList(String ... uploadTime){
            this.uploadTimeList = solveNullList(uploadTime);
            return this;
        }

        public QueryBuilder uploadTimeList(List<String> uploadTime){
            this.uploadTimeList = uploadTime;
            return this;
        }

        public QueryBuilder fetchUploadTime(){
            setFetchFields("fetchFields","uploadTime");
            return this;
        }

        public QueryBuilder excludeUploadTime(){
            setFetchFields("excludeFields","uploadTime");
            return this;
        }

        public QueryBuilder uploadGroupIDBetWeen(Integer uploadGroupIDSt,Integer uploadGroupIDEd){
            this.uploadGroupIDSt = uploadGroupIDSt;
            this.uploadGroupIDEd = uploadGroupIDEd;
            return this;
        }

        public QueryBuilder uploadGroupIDGreaterEqThan(Integer uploadGroupIDSt){
            this.uploadGroupIDSt = uploadGroupIDSt;
            return this;
        }
        public QueryBuilder uploadGroupIDLessEqThan(Integer uploadGroupIDEd){
            this.uploadGroupIDEd = uploadGroupIDEd;
            return this;
        }


        public QueryBuilder uploadGroupID(Integer uploadGroupID){
            setUploadGroupID(uploadGroupID);
            return this;
        }

        public QueryBuilder uploadGroupIDList(Integer ... uploadGroupID){
            this.uploadGroupIDList = solveNullList(uploadGroupID);
            return this;
        }

        public QueryBuilder uploadGroupIDList(List<Integer> uploadGroupID){
            this.uploadGroupIDList = uploadGroupID;
            return this;
        }

        public QueryBuilder fetchUploadGroupID(){
            setFetchFields("fetchFields","uploadGroupID");
            return this;
        }

        public QueryBuilder excludeUploadGroupID(){
            setFetchFields("excludeFields","uploadGroupID");
            return this;
        }

        public QueryBuilder uploadUserIDBetWeen(Integer uploadUserIDSt,Integer uploadUserIDEd){
            this.uploadUserIDSt = uploadUserIDSt;
            this.uploadUserIDEd = uploadUserIDEd;
            return this;
        }

        public QueryBuilder uploadUserIDGreaterEqThan(Integer uploadUserIDSt){
            this.uploadUserIDSt = uploadUserIDSt;
            return this;
        }
        public QueryBuilder uploadUserIDLessEqThan(Integer uploadUserIDEd){
            this.uploadUserIDEd = uploadUserIDEd;
            return this;
        }


        public QueryBuilder uploadUserID(Integer uploadUserID){
            setUploadUserID(uploadUserID);
            return this;
        }

        public QueryBuilder uploadUserIDList(Integer ... uploadUserID){
            this.uploadUserIDList = solveNullList(uploadUserID);
            return this;
        }

        public QueryBuilder uploadUserIDList(List<Integer> uploadUserID){
            this.uploadUserIDList = uploadUserID;
            return this;
        }

        public QueryBuilder fetchUploadUserID(){
            setFetchFields("fetchFields","uploadUserID");
            return this;
        }

        public QueryBuilder excludeUploadUserID(){
            setFetchFields("excludeFields","uploadUserID");
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

        public GroupFile build(){return this;}
    }


    public static class ConditionBuilder{
        private List<Integer> fileIDList;

        public List<Integer> getFileIDList(){return this.fileIDList;}

        private Integer fileIDSt;

        private Integer fileIDEd;

        public Integer getFileIDSt(){return this.fileIDSt;}

        public Integer getFileIDEd(){return this.fileIDEd;}

        private List<String> fileNameList;

        public List<String> getFileNameList(){return this.fileNameList;}


        private List<String> fuzzyFileName;

        public List<String> getFuzzyFileName(){return this.fuzzyFileName;}

        private List<String> rightFuzzyFileName;

        public List<String> getRightFuzzyFileName(){return this.rightFuzzyFileName;}
        private List<String> fileUrlList;

        public List<String> getFileUrlList(){return this.fileUrlList;}


        private List<String> fuzzyFileUrl;

        public List<String> getFuzzyFileUrl(){return this.fuzzyFileUrl;}

        private List<String> rightFuzzyFileUrl;

        public List<String> getRightFuzzyFileUrl(){return this.rightFuzzyFileUrl;}
        private List<String> uploadTimeList;

        public List<String> getUploadTimeList(){return this.uploadTimeList;}


        private List<String> fuzzyUploadTime;

        public List<String> getFuzzyUploadTime(){return this.fuzzyUploadTime;}

        private List<String> rightFuzzyUploadTime;

        public List<String> getRightFuzzyUploadTime(){return this.rightFuzzyUploadTime;}
        private List<Integer> uploadGroupIDList;

        public List<Integer> getUploadGroupIDList(){return this.uploadGroupIDList;}

        private Integer uploadGroupIDSt;

        private Integer uploadGroupIDEd;

        public Integer getUploadGroupIDSt(){return this.uploadGroupIDSt;}

        public Integer getUploadGroupIDEd(){return this.uploadGroupIDEd;}

        private List<Integer> uploadUserIDList;

        public List<Integer> getUploadUserIDList(){return this.uploadUserIDList;}

        private Integer uploadUserIDSt;

        private Integer uploadUserIDEd;

        public Integer getUploadUserIDSt(){return this.uploadUserIDSt;}

        public Integer getUploadUserIDEd(){return this.uploadUserIDEd;}


        public ConditionBuilder fileIDBetWeen(Integer fileIDSt,Integer fileIDEd){
            this.fileIDSt = fileIDSt;
            this.fileIDEd = fileIDEd;
            return this;
        }

        public ConditionBuilder fileIDGreaterEqThan(Integer fileIDSt){
            this.fileIDSt = fileIDSt;
            return this;
        }
        public ConditionBuilder fileIDLessEqThan(Integer fileIDEd){
            this.fileIDEd = fileIDEd;
            return this;
        }


        public ConditionBuilder fileIDList(Integer ... fileID){
            this.fileIDList = solveNullList(fileID);
            return this;
        }

        public ConditionBuilder fileIDList(List<Integer> fileID){
            this.fileIDList = fileID;
            return this;
        }

        public ConditionBuilder fuzzyFileName (List<String> fuzzyFileName){
            this.fuzzyFileName = fuzzyFileName;
            return this;
        }

        public ConditionBuilder fuzzyFileName (String ... fuzzyFileName){
            this.fuzzyFileName = solveNullList(fuzzyFileName);
            return this;
        }

        public ConditionBuilder rightFuzzyFileName (List<String> rightFuzzyFileName){
            this.rightFuzzyFileName = rightFuzzyFileName;
            return this;
        }

        public ConditionBuilder rightFuzzyFileName (String ... rightFuzzyFileName){
            this.rightFuzzyFileName = solveNullList(rightFuzzyFileName);
            return this;
        }

        public ConditionBuilder fileNameList(String ... fileName){
            this.fileNameList = solveNullList(fileName);
            return this;
        }

        public ConditionBuilder fileNameList(List<String> fileName){
            this.fileNameList = fileName;
            return this;
        }

        public ConditionBuilder fuzzyFileUrl (List<String> fuzzyFileUrl){
            this.fuzzyFileUrl = fuzzyFileUrl;
            return this;
        }

        public ConditionBuilder fuzzyFileUrl (String ... fuzzyFileUrl){
            this.fuzzyFileUrl = solveNullList(fuzzyFileUrl);
            return this;
        }

        public ConditionBuilder rightFuzzyFileUrl (List<String> rightFuzzyFileUrl){
            this.rightFuzzyFileUrl = rightFuzzyFileUrl;
            return this;
        }

        public ConditionBuilder rightFuzzyFileUrl (String ... rightFuzzyFileUrl){
            this.rightFuzzyFileUrl = solveNullList(rightFuzzyFileUrl);
            return this;
        }

        public ConditionBuilder fileUrlList(String ... fileUrl){
            this.fileUrlList = solveNullList(fileUrl);
            return this;
        }

        public ConditionBuilder fileUrlList(List<String> fileUrl){
            this.fileUrlList = fileUrl;
            return this;
        }

        public ConditionBuilder fuzzyUploadTime (List<String> fuzzyUploadTime){
            this.fuzzyUploadTime = fuzzyUploadTime;
            return this;
        }

        public ConditionBuilder fuzzyUploadTime (String ... fuzzyUploadTime){
            this.fuzzyUploadTime = solveNullList(fuzzyUploadTime);
            return this;
        }

        public ConditionBuilder rightFuzzyUploadTime (List<String> rightFuzzyUploadTime){
            this.rightFuzzyUploadTime = rightFuzzyUploadTime;
            return this;
        }

        public ConditionBuilder rightFuzzyUploadTime (String ... rightFuzzyUploadTime){
            this.rightFuzzyUploadTime = solveNullList(rightFuzzyUploadTime);
            return this;
        }

        public ConditionBuilder uploadTimeList(String ... uploadTime){
            this.uploadTimeList = solveNullList(uploadTime);
            return this;
        }

        public ConditionBuilder uploadTimeList(List<String> uploadTime){
            this.uploadTimeList = uploadTime;
            return this;
        }

        public ConditionBuilder uploadGroupIDBetWeen(Integer uploadGroupIDSt,Integer uploadGroupIDEd){
            this.uploadGroupIDSt = uploadGroupIDSt;
            this.uploadGroupIDEd = uploadGroupIDEd;
            return this;
        }

        public ConditionBuilder uploadGroupIDGreaterEqThan(Integer uploadGroupIDSt){
            this.uploadGroupIDSt = uploadGroupIDSt;
            return this;
        }
        public ConditionBuilder uploadGroupIDLessEqThan(Integer uploadGroupIDEd){
            this.uploadGroupIDEd = uploadGroupIDEd;
            return this;
        }


        public ConditionBuilder uploadGroupIDList(Integer ... uploadGroupID){
            this.uploadGroupIDList = solveNullList(uploadGroupID);
            return this;
        }

        public ConditionBuilder uploadGroupIDList(List<Integer> uploadGroupID){
            this.uploadGroupIDList = uploadGroupID;
            return this;
        }

        public ConditionBuilder uploadUserIDBetWeen(Integer uploadUserIDSt,Integer uploadUserIDEd){
            this.uploadUserIDSt = uploadUserIDSt;
            this.uploadUserIDEd = uploadUserIDEd;
            return this;
        }

        public ConditionBuilder uploadUserIDGreaterEqThan(Integer uploadUserIDSt){
            this.uploadUserIDSt = uploadUserIDSt;
            return this;
        }
        public ConditionBuilder uploadUserIDLessEqThan(Integer uploadUserIDEd){
            this.uploadUserIDEd = uploadUserIDEd;
            return this;
        }


        public ConditionBuilder uploadUserIDList(Integer ... uploadUserID){
            this.uploadUserIDList = solveNullList(uploadUserID);
            return this;
        }

        public ConditionBuilder uploadUserIDList(List<Integer> uploadUserID){
            this.uploadUserIDList = uploadUserID;
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

        private GroupFile obj;

        public Builder(){
            this.obj = new GroupFile();
        }

        public Builder fileID(Integer fileID){
            this.obj.setFileID(fileID);
            return this;
        }
        public Builder fileName(String fileName){
            this.obj.setFileName(fileName);
            return this;
        }
        public Builder fileUrl(String fileUrl){
            this.obj.setFileUrl(fileUrl);
            return this;
        }
        public Builder uploadTime(String uploadTime){
            this.obj.setUploadTime(uploadTime);
            return this;
        }
        public Builder uploadGroupID(Integer uploadGroupID){
            this.obj.setUploadGroupID(uploadGroupID);
            return this;
        }
        public Builder uploadUserID(Integer uploadUserID){
            this.obj.setUploadUserID(uploadUserID);
            return this;
        }
        public GroupFile build(){return obj;}
    }

}
