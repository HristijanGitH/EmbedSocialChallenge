package org.example;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class FilterReviews extends JFrame{
    private JPanel mainPanel;
    private JLabel filterReviewsLabel;
    private JLabel orderByRatingLabel;
    private JLabel minimumRatingLabel;
    private JLabel orderByDateLabel;
    private JLabel prioritizeByTextLabel;
    private JComboBox orderByRatingCb;
    private JComboBox minimumRatingCb;
    private JComboBox orderByDateCb;
    private JComboBox prioritizeByTextCb;
    private JButton filterButton;


    public FilterReviews(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(500, 600);
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gson gson = new Gson();

                try {
                    //Used fromJson method from Gson to parse the JSON string into java object with which I can work later
                    Review[] review = gson.fromJson(new FileReader("D:\\EmbedSocial\\EmbedSocial1\\reviews.json"),Review[].class);
                    //Used StringBuilder to be able to display the filtered reviews in a message using JOptionPane.showMessageDialog() method.
                    StringBuilder sb = new StringBuilder();
                    //Needed to cast the minimunRatingCb object to integer so I can compare them to be able to sort only the ones with the minimum rating
                    int minimumRating = Integer.valueOf((String) minimumRatingCb.getSelectedItem());
                    //It is a little messy code and enormous if/else statements, but works on the basic principle which takes in consideration every scenario.It is possible to make it smaller using lambda expressions,
                    //but I had more overview like this.
                    if(prioritizeByTextCb.getSelectedItem().equals("Yes")){
                        if(orderByDateCb.getSelectedItem().equals("Newest First")){
                            if(orderByRatingCb.getSelectedItem().equals("Highest First")){
                                Arrays.sort(review,new DateSorter());
                                Arrays.sort(review,new RatingSorter());
                                Arrays.sort(review,new TextSorter());
                                for(Review rev: review){
                                    if(rev.getRating() >=  minimumRating) {
                                        sb.append(rev);
                                    }
                                }
                            }
                            else{
                                Arrays.sort(review,new DateSorter());
                                Arrays.sort(review,new RatingSorter().reversed());
                                StringBuilder temp1 = new StringBuilder();
                                for(Review rev: review){
                                    if(!rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp1.append(rev);
                                        }
                                    }
                                }
                                StringBuilder temp2 = new StringBuilder();
                                for(Review rev: review){
                                    if(rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp2.append(rev);
                                        }
                                    }
                                }
                                temp1.append(temp2);
                                sb.append(temp1);
                            }
                        }
                        else{
                            if(orderByRatingCb.getSelectedItem().equals("Highest First")){
                                Arrays.sort(review,new DateSorter().reversed());
                                Arrays.sort(review,new RatingSorter());
                                Arrays.sort(review,new TextSorter());
                                for(Review rev: review){
                                    if(rev.getRating() >=  minimumRating){
                                        sb.append(rev);
                                    }
                                }
                            }
                            else{
                                Arrays.sort(review,new DateSorter().reversed());
                                Arrays.sort(review,new RatingSorter().reversed());
                                StringBuilder temp1 = new StringBuilder();
                                for(Review rev: review){
                                    if(!rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp1.append(rev);
                                        }
                                    }
                                }
                                StringBuilder temp2 = new StringBuilder();
                                for(Review rev: review){
                                    if(rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp2.append(rev);
                                        }
                                    }
                                }
                                temp1.append(temp2);
                                sb.append(temp1);
                            }
                        }
                    }
                    else{
                        if(orderByDateCb.getSelectedItem().equals("Newest First")){
                            if(orderByRatingCb.getSelectedItem().equals("Highest First")){
                                Arrays.sort(review,new DateSorter());
                                Arrays.sort(review,new RatingSorter());
                                for(Review rev: review){
                                    if(rev.getRating() >=  minimumRating){
                                        sb.append(rev);
                                    }
                                }
                            }
                            else{
                                Arrays.sort(review,new DateSorter());
                                Arrays.sort(review,new RatingSorter().reversed());
                                StringBuilder temp1 = new StringBuilder();
                                for(Review rev: review){
                                    if(!rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp1.append(rev);
                                        }
                                    }
                                }
                                StringBuilder temp2 = new StringBuilder();
                                for(Review rev: review){
                                    if(rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp2.append(rev);
                                        }
                                    }
                                }
                                temp1.append(temp2);
                                sb.append(temp1);
                            }
                        }
                        else{
                            if(orderByRatingCb.getSelectedItem().equals("Highest First")){
                                Arrays.sort(review,new DateSorter().reversed());
                                Arrays.sort(review,new RatingSorter());
                                for(Review rev: review){
                                    if(rev.getRating() >=  minimumRating){
                                        sb.append(rev);
                                    }
                                }
                            }
                            else{
                                Arrays.sort(review,new DateSorter().reversed());
                                Arrays.sort(review,new RatingSorter().reversed());
                                StringBuilder temp1 = new StringBuilder();
                                for(Review rev: review){
                                    if(!rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp1.append(rev);
                                        }
                                    }
                                }
                                StringBuilder temp2 = new StringBuilder();
                                for(Review rev: review){
                                    if(rev.getReviewFullText().isEmpty()){
                                        if(rev.getRating() >=  minimumRating){
                                            temp2.append(rev);
                                        }
                                    }
                                }
                                temp1.append(temp2);
                                sb.append(temp1);
                            }
                        }
                    }
                    //The results are displayed in Dialog Message after you click the "Filter" button.
                    JOptionPane.showMessageDialog(null,sb);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new FilterReviews("Filter Reviews");
        frame.setVisible(true);
    }
}
