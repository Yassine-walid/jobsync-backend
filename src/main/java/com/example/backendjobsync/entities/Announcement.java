package com.example.backendjobsync.entities;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"enterprise"})
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String bannerUrl;
    private String domain;
    private String degree;
    private int yearsExp;
    @Temporal(TemporalType.DATE)
    private Date puclicationDate;
    private String formUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enterprise_id", nullable = false)
    @JsonIgnoreProperties("announcements")
    private Enterprise enterprise;

//    @JsonProperty("enterprise") // Custom serialization for enterprise data
//    public String getEnterpriseData() {
//        if (enterprise != null) {
//            // Construct a JSON object representing enterprise data
//            ObjectMapper mapper = new ObjectMapper();
//            try {
//                return mapper.writeValueAsString(enterprise);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

//    @Override
//    public String toString() {
//        return "Announcement{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", bannerUrl='" + bannerUrl + '\'' +
//                ", domain='" + domain + '\'' +
//                ", degree='" + degree + '\'' +
//                ", yearsExp=" + yearsExp +
//                ", publicationDate=" + puclicationDate +
//                ", enterprise=" + (enterprise != null ?
//                "Enterprise{id=" + enterprise.getId() +
//                        ", name='" + enterprise.getName() + '\'' +
//                        ", description='" + enterprise.getDescription() + '\'' +
//                        ", foundationDate=" + enterprise.getFoundationDate() +
//                        ", address='" + enterprise.getAddress() + '\'' +
//                        ", email='" + enterprise.getEmail() + '\'' +
//                        ", logoUrl='" + enterprise.getLogoUrl() + '\'' +
//                        ", phoneNumber=" + enterprise.getPhoneNumber() +
//                        ", websiteUrl='" + enterprise.getWebsiteUrl() + '\'' +
//                        '}' : "null") +
//                '}';
//    }






}





