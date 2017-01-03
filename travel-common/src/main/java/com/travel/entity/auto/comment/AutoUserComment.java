package com.travel.entity.auto.comment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;

import com.travel.data.tag.Tag;


@Entity(name = "auto_user_comment")
//@Table(uniqueConstraints=@UniqueConstraint(
//		columnNames={"rawId","commentId"},name="uniqueIdx"))
public class AutoUserComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2824475101884503713L;
	
	final static public int CREATE_TYPE_AUTO = 1;
	final static public int CREATE_TYPE_MIX = 2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Index(name="raw_id")
	private Long rawId;
	private Long mergeId;
	private String commentId;
	@Column(columnDefinition="varchar(500)",length=500)
	private String userPic;
	private String poUserPic;
	private String userName;
	private String userId;
	private String starLevel;
	@Column(columnDefinition="varchar(4000)",length=4000)
	private String commentText;
	private String commentTitle;
	private String commentTime;
	private String commentProdScore;
	private String commentEnvriomentScore;
	private String commentServiceScore;
	private String location;
	private String dataLang;
	private Date updateTs;
	//用来标识,餐饮的米其林餐厅
	private String starTag;
	/**
	 * 0:表示抓取来还没有被处理过的评论<br/>
	 * 1:表示评论已被清洗过<br/>
	 * 2:表示从rawData里取出的评论<br/>
	 * 3:表示人工处理过tag不会被覆盖
	 * -1:表示被删除
	 */
	private Integer flag = 0;
	/**
	 * 原始tag,用\001分隔
	 */
	@Column(columnDefinition="varchar(1000)",length=1000)
	private String originTag;
	/**
	 * 归一化过的tag,用\001分隔
	 */
	@Column(columnDefinition="varchar(1000)",length=1000)
	private String absTags;
	/**
	 * 品牌tag,用\001分隔
	 */
	@Column(columnDefinition="varchar(1000)",length=1000)
	private String brandsTags;
	@Lob
	private String detail;
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String commentPics;
	@Column(columnDefinition="varchar(1500)",length=1500)
	private String poCommentPics;
	@Column(columnDefinition="varchar(3000)",length=3000)
	private String largeCommentPics;
	@Column(columnDefinition="varchar(1500)",length=1500)
	private String poLargeCommentPics;
	@Transient
	private List<String> comments;
	@Transient
	private List<Tag> brandList;
	@Transient
	private List<Tag> tagList;
	@Transient
	private String placeType;
	private Integer createType;
	
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommentPics() {
		return commentPics;
	}
	public void setCommentPics(String commentPics) {
		this.commentPics = commentPics;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getCommentTitle() {
		return commentTitle;
	}
	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentProdScore() {
		return commentProdScore;
	}
	public void setCommentProdScore(String commentProdScore) {
		this.commentProdScore = commentProdScore;
	}
	public String getCommentEnvriomentScore() {
		return commentEnvriomentScore;
	}
	public void setCommentEnvriomentScore(String commentEnvriomentScore) {
		this.commentEnvriomentScore = commentEnvriomentScore;
	}
	public String getCommentServiceScore() {
		return commentServiceScore;
	}
	public void setCommentServiceScore(String commentServiceScore) {
		this.commentServiceScore = commentServiceScore;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Long getRawId() {
		return rawId;
	}
	public void setRawId(Long rawId) {
		this.rawId = rawId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDataLang() {
		return dataLang;
	}
	public void setDataLang(String dataLang) {
		this.dataLang = dataLang;
	}
	public Long getMergeId() {
		return mergeId;
	}
	public void setMergeId(Long mergeId) {
		this.mergeId = mergeId;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getOriginTag() {
		return originTag;
	}
	public void setOriginTag(String originTag) {
		this.originTag = originTag;
	}
	public String getAbsTags() {
		return absTags;
	}
	public void setAbsTags(String absTags) {
		this.absTags = absTags;
	}
	public String getPoUserPic() {
		return poUserPic;
	}
	public void setPoUserPic(String poUserPic) {
		this.poUserPic = poUserPic;
	}
	public String getPoCommentPics() {
		return poCommentPics;
	}
	public void setPoCommentPics(String poCommentPics) {
		this.poCommentPics = poCommentPics;
	}
	public String getBrandsTags() {
		return brandsTags;
	}
	public void setBrandsTags(String brandsTags) {
		this.brandsTags = brandsTags;
	}
	public void setDelete(){
		this.flag = -1;
	}
	public String getLargeCommentPics() {
		return largeCommentPics;
	}
	public void setLargeCommentPics(String largeCommentPics) {
		this.largeCommentPics = largeCommentPics;
	}
	public String getPoLargeCommentPics() {
		return poLargeCommentPics;
	}
	public void setPoLargeCommentPics(String poLargeCommentPics) {
		this.poLargeCommentPics = poLargeCommentPics;
	}
	public Date getUpdateTs() {
		return updateTs;
	}
	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}
	public String getStarTag() {
		return starTag;
	}
	public void setStarTag(String starTag) {
		this.starTag = starTag;
	}
	public List<Tag> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<Tag> brandList) {
		this.brandList = brandList;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public Integer getCreateType() {
		return createType;
	}
	public void setCreateType(Integer createType) {
		this.createType = createType;
	}
}
