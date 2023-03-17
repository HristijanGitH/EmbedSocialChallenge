package org.example;
import java.util.Comparator;
import java.util.List;

public  class Review implements Comparable<Review> {
    private Long id;
    private String reviewId;
    private String reviewFullText;
    private String reviewText;
    private  Integer numLikes;
    private  Integer numComments;
    private  Integer numShares;
    private  Integer rating;
    private  String reviewCreatedOn;
    private  String reviewCreatedOnDate;
    private  Integer reviewCreatedOnTime;
    private  String reviewerId;
    private  String reviewerUrl;
    private  String reviewerName;
    private  String reviewerEmail;
    private  String sourceType;
    private  Boolean isVerified;
    private  String source;
    private  String sourceName;
    private  String sourceId;
    private List<String> tags;
    private  String href;
    private  String logoHref;
    private  List<String> photos;

    public Review(Long id, String reviewId, String reviewFullText, String reviewText, Integer numLikes, Integer numComments, Integer numShares, Integer rating, String reviewCreatedOn, String reviewCreatedOnDate, Integer reviewCreatedOnTime, String reviewerId, String reviewerUrl, String reviewerName, String reviewerEmail, String sourceType, Boolean isVerified, String source, String sourceName, String sourceId, List<String> tags, String href, String logoHref, List<String> photos) {
        this.id = id;
        this.reviewId = reviewId;
        this.reviewFullText = reviewFullText;
        this.reviewText = reviewText;
        this.numLikes = numLikes;
        this.numComments = numComments;
        this.numShares = numShares;
        this.rating = rating;
        this.reviewCreatedOn = reviewCreatedOn;
        this.reviewCreatedOnDate = reviewCreatedOnDate;
        this.reviewCreatedOnTime = reviewCreatedOnTime;
        this.reviewerId = reviewerId;
        this.reviewerUrl = reviewerUrl;
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
        this.sourceType = sourceType;
        this.isVerified = isVerified;
        this.source = source;
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.tags = tags;
        this.href = href;
        this.logoHref = logoHref;
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewFullText() {
        return reviewFullText;
    }

    public void setReviewFullText(String reviewFullText) {
        this.reviewFullText = reviewFullText;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(Integer numLikes) {
        this.numLikes = numLikes;
    }

    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    public Integer getNumShares() {
        return numShares;
    }

    public void setNumShares(Integer numShares) {
        this.numShares = numShares;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewCreatedOn() {
        return reviewCreatedOn;
    }

    public void setReviewCreatedOn(String reviewCreatedOn) {
        this.reviewCreatedOn = reviewCreatedOn;
    }

    public String getReviewCreatedOnDate() {
        return reviewCreatedOnDate;
    }

    public void setReviewCreatedOnDate(String reviewCreatedOnDate) {
        this.reviewCreatedOnDate = reviewCreatedOnDate;
    }

    public Integer getReviewCreatedOnTime() {
        return reviewCreatedOnTime;
    }

    public void setReviewCreatedOnTime(Integer reviewCreatedOnTime) {
        this.reviewCreatedOnTime = reviewCreatedOnTime;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getReviewerUrl() {
        return reviewerUrl;
    }

    public void setReviewerUrl(String reviewerUrl) {
        this.reviewerUrl = reviewerUrl;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public void setReviewerEmail(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLogoHref() {
        return logoHref;
    }

    public void setLogoHref(String logoHref) {
        this.logoHref = logoHref;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
    //Modified the toString() method to print the essential data of the reviews.
    @Override
    public String toString(){
        return "\n"+"Id: "+getId()+" --- "+"Full review text: "+getReviewText()+" --- "+"Date when the review was created: "+getReviewCreatedOnDate()+" --- "+"Rating: "+getRating()+"\n";
    }

    //Override the compareTo() method so I can implement the sorter classes
    @Override
    public int compareTo(Review o) {
        return this.getRating() - o.getRating();
    }
}
//Sorter classes to sort the array of reviews
class RatingSorter implements Comparator<Review>{
    @Override
    public int compare(Review o1, Review o2) {
        return o2.getRating() - o1.getRating();
    }
}

class DateSorter implements Comparator<Review>{
    @Override
    public int compare(Review o1, Review o2) {
        return o2.getReviewCreatedOnDate().compareTo(o1.getReviewCreatedOnDate());
    }
}

class TextSorter implements Comparator<Review>{
    @Override
    public int compare(Review o1, Review o2) {
        return o2.getReviewFullText().compareTo(o1.getReviewFullText());
    }
}