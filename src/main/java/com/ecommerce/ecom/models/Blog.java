package com.ecommerce.ecom.models;

import java.util.Date;

import com.ecommerce.ecom.enums.BlogTags;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
 
@Entity
@Table(name ="blog")
public class Blog extends Root {
    
    @Column
    private String title;
    
    @Column
    private String body;
    
    @Column
    private Date creationDate;
    
    @Column
    private int readTime;
    
    @Enumerated(EnumType.STRING)
    private BlogTags blogTags;
    
    @Column
    private String coverImagePath;
    
    public String getCoverImagePath() {
        return coverImagePath;
    }
 
    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }
 
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "reaction_id", referencedColumnName = "id")
     
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getBody() {
        return body;
    }
 
    public void setBody(String body) {
        this.body = body;
    }
 
    public Date getCreationDate() {
        return creationDate;
    }
 
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
 
    public int getReadTime() {
        return readTime;
    }
 
    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }
 
    public BlogTags getBlogTags() {
        return blogTags;
    }
 
    public void setBlogTags(BlogTags blogTags) {
        this.blogTags = blogTags;
    }
}