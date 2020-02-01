package org.easymis.easysaas.open.orientdb;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
/**
 * 
* @ClassName: FiveOneWit
* @Description: TODO(智脉)
* @author lenovo-t
* @date 2019年9月1日
*
 */
public class FiveOneWit {
	public static void main(String[] args) {

        OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        ODatabaseSession db = orient.open("test", "root", "root");
        //chua
        createSchema(db);

        createMember(db);

        executeAQuery(db);

        executeAnotherQuery(db);

        db.close();
        orient.close();

    }
	/**
	 * 
	* @Title: createSchema
	* @Description: TODO(创建表)
	* @param @param db    设定文件
	* @return void    返回类型
	* @throws
	 */
    private static void createSchema(ODatabaseSession db) {
    	//级或集群|表
        OClass member = db.getClass("Member");

        if (member == null) {
            member = db.createVertexClass("Member");
        }
       //会员信息表
        if (member.getProperty("name") == null) {
        	//OrientDB中的属性类似于数据库表中的类和列的字段。
        	//会员id
        	member.createProperty("memberId", OType.STRING);
        	//姓名
            member.createProperty("name", OType.STRING);
            //状态
            member.createProperty("status", OType.STRING);
            member.createIndex("Member_name_index", OClass.INDEX_TYPE.NOTUNIQUE, "name");
        }
        //父亲
        if (db.getClass("FatherOf") == null) {
            db.createEdgeClass("FatherOf");
        }
        //母亲
        if (db.getClass("MotherOf") == null) {
            db.createEdgeClass("MotherOf");
        }
        //妻子
        if (db.getClass("WifeOf") == null) {
            db.createEdgeClass("WifeOf");
        }
        //丈夫
        if (db.getClass("HusbandOf") == null) {
            db.createEdgeClass("HusbandOf");
        }
        //
        //儿子
        if (db.getClass("SonOf") == null) {
            db.createEdgeClass("SonOf");
        }
        //女儿
        if (db.getClass("DaughterOf") == null) {
            db.createEdgeClass("DaughterOf");
        }
        //亲姐妹
        if (db.getClass("SisterOf") == null) {
            db.createEdgeClass("SisterOf");
        }
        //亲兄弟
        if (db.getClass("BrotherOf") == null) {
            db.createEdgeClass("BrotherOf");
        }
        //grandfather, grandmother(祖/外祖父&母)
        //祖父
        if (db.getClass("Grandfather1Of") == null) {
            db.createEdgeClass("Grandfather1Of");
        }
        //祖母
        if (db.getClass("Grandmother1Of") == null) {
            db.createEdgeClass("Grandmother1Of");
        }
        //外祖父
        if (db.getClass("Grandfather2Of") == null) {
            db.createEdgeClass("Grandfather2Of");
        }
        //外祖母
        if (db.getClass("Grandmother2Of") == null) {
            db.createEdgeClass("Grandmother2Of");
        }
        //grandson, granddaughter(孙/外孙子&女)
        //孙子
        if (db.getClass("Grandson1Of") == null) {
            db.createEdgeClass("Grandson1Of");
        }
        //孙女
        if (db.getClass("Granddaughter1Of") == null) {
            db.createEdgeClass("Granddaughter1Of");
        }
        //外孙儿
        if (db.getClass("Grandson2Of") == null) {
            db.createEdgeClass("Grandson2Of");
        }
        //外孙子
        if (db.getClass("Granddaughter2Of") == null) {
            db.createEdgeClass("Granddaughter2Of");
        }
        //岳父
        if (db.getClass("FatherInLawOf") == null) {
            db.createEdgeClass("FatherInLawOf");
        }
        //岳母
        if (db.getClass("MotherInLawOf") == null) {
            db.createEdgeClass("MotherInLawOf");
        }
        //女婿
        if (db.getClass("SonInLawOf") == null) {
            db.createEdgeClass("SonInLawOf");
        }
        //儿媳
		if (db.getClass("DaughterInLawOf") == null) {
			db.createEdgeClass("DaughterInLawOf");
		}
		// stepfather, (继父))
		if (db.getClass("StepfatherOf") == null) {
			db.createEdgeClass("StepfatherOf");
		}
		//继母
		if (db.getClass("StepmotherOf") == null) {
			db.createEdgeClass("StepmotherOf");
		}		
        //继子, stepdaughter()
        if (db.getClass("DaughterInLawOf") == null) {
            db.createEdgeClass("DaughterInLawOf");
        }
        //继女
        if (db.getClass("DaughterInLawOf") == null) {
            db.createEdgeClass("DaughterInLawOf");
        }
        //nephew(侄子)
        if (db.getClass("Nephew1Of") == null) {
            db.createEdgeClass("Nephew1Of");
        }
        //外甥
        if (db.getClass("Nephew2Of") == null) {
            db.createEdgeClass("Nephew2Of");
        }
        //niece(侄女、等)
        if (db.getClass("Niece1Of") == null) {
            db.createEdgeClass("Niece1Of");
        }
        //外甥女
        if (db.getClass("Niece2Of") == null) {
            db.createEdgeClass("Niece2Of");
        }
        //伯伯
        if (db.getClass("Uncle1Of") == null) {
            db.createEdgeClass("Uncle1Of");
        }
        //叔叔
        if (db.getClass("Uncle2Of") == null) {
            db.createEdgeClass("Uncle2Of");
        }
        //舅舅
        if (db.getClass("Uncle3Of") == null) {
            db.createEdgeClass("Uncle3Of");
        }
        //姑父
        if (db.getClass("Uncle4Of") == null) {
            db.createEdgeClass("Uncle4Of");
        }
        //姨父
        if (db.getClass("Uncle5Of") == null) {
            db.createEdgeClass("Uncle5Of");
        }
        //姑姑
        if (db.getClass("Aunt1Of") == null) {
            db.createEdgeClass("Aunt1Of");
        }
        //姨妈
        if (db.getClass("Aunt2Of") == null) {
            db.createEdgeClass("Aunt2Of");
        }
        //婶婶
        if (db.getClass("Aunt3Of") == null) {
            db.createEdgeClass("Aunt3Of");
        }
        //舅妈
        if (db.getClass("Aunt4Of") == null) {
            db.createEdgeClass("Aunt4Of");
        }
        //堂兄 cousin(堂/表兄弟姐妹，也就是uncle或aunt的孩子，不是亲的)
        if (db.getClass("Cousin1Of") == null) {
            db.createEdgeClass("Cousin1Of");
        }
        //堂第
        if (db.getClass("Cousin2Of") == null) {
            db.createEdgeClass("Cousin2Of");
        }
        //堂姐
        if (db.getClass("Cousin3Of") == null) {
            db.createEdgeClass("Cousin3Of");
        }
        //堂妹
        if (db.getClass("Cousin4Of") == null) {
            db.createEdgeClass("Cousin4Of");
        }
        //表兄
        if (db.getClass("Cousin5Of") == null) {
            db.createEdgeClass("Cousin5Of");
        }
        //表弟
        if (db.getClass("Cousin6Of") == null) {
            db.createEdgeClass("Cousin6Of");
        }
        //表姐
        if (db.getClass("Cousin7Of") == null) {
            db.createEdgeClass("Cousin7Of");
        }
        //表妹
        if (db.getClass("Cousin8Of") == null) {
            db.createEdgeClass("Cousin8Of");
        }
        //姐夫brother-in-law(姐妹的丈夫，妻子的兄弟)
        if (db.getClass("BrotherInLaw1Of") == null) {
            db.createEdgeClass("BrotherInLaw1Of");
        }
        //妹夫
        if (db.getClass("BrotherInLaw2Of") == null) {
            db.createEdgeClass("BrotherInLaw2Of");
        }
        //妻兄
        if (db.getClass("BrotherInLaw3Of") == null) {
            db.createEdgeClass("BrotherInLaw3Of");
        }
        //妻弟
        if (db.getClass("BrotherInLaw4Of") == null) {
            db.createEdgeClass("BrotherInLaw4Of");
        }
        //其它亲属
        if (db.getClass("KinsfolkOf") == null) {
            db.createEdgeClass("KinsfolkOf");
        }
        //同学
        if (db.getClass("ClassmateOf") == null) {
            db.createEdgeClass("ClassmateOf");
        }
        //战友Comrade
        if (db.getClass("ComradeOf") == null) {
            db.createEdgeClass("ComradeOf");
        }
        //朋友
        if (db.getClass("FriendOf") == null) {
            db.createEdgeClass("FriendOf");
        }
        //同事
        if (db.getClass("WorkmateOf") == null) {
            db.createEdgeClass("WorkmateOf");
        }
        //老乡
        if (db.getClass("HometownOf") == null) {
            db.createEdgeClass("HometownOf");
        }
        //贵人        
        if (db.getClass("HelpfulOf") == null) {
            db.createEdgeClass("HelpfulOf");
        }
        //
    }
    /**
     * 
    * @Title: createPeople
    * @Description: TODO(插入记录)
    * @param @param db    设定文件
    * @return void    返回类型
    * @throws
     */
    private static void createMember(ODatabaseSession db) {
        OVertex alice = createMember(db, "谭宇杰");
        OVertex bob = createMember(db, "叶再洪");
        OVertex jim = createMember(db, "晏君");

        OEdge edge1 = alice.addEdge(bob, "FriendOf");
        edge1.save();
        OEdge edge2 = bob.addEdge(jim, "FriendOf");
        edge2.save();
    }
    /**
     * 
    * @Title: createMember
    * @Description: TODO(这里用一句话描述这个方法的作用)
    * @param @param db
    * @param @param name 中文姓名
    * @param @param surname
    * @param @return    设定文件
    * @return OVertex    返回类型
    * @throws
     */
    private static OVertex createMember(ODatabaseSession db, String name) {
        OVertex result = db.newVertex("Member");
        result.setProperty("memberId", UUID.randomUUID());
        result.setProperty("name", name);
        result.setProperty("status", "1");
        result.save();
        return result;
    }

    private static void executeAQuery(ODatabaseSession db) {
        String query = "SELECT expand(out('FriendOf').out('FriendOf')) from Member where name = ?";
        OResultSet rs = db.query(query, "Alice");

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("friend: " + item.getProperty("name"));
        }

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
    }

    private static void executeAnotherQuery(ODatabaseSession db) {
        String query =
                " MATCH                                           " +
                        "   {class:Member, as:a, where: (name = :name1)}, " +
                        "   {class:Member, as:b, where: (name = :name2)}, " +
                        "   {as:a} -FriendOf-> {as:x} -FriendOf-> {as:b}  " +
                        " RETURN x.name as friend                         ";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name1", "Alice");
        params.put("name2", "Jim");

        OResultSet rs = db.query(query, params);

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("friend: " + item.getProperty("friend"));
        }

        rs.close();
    }
}
