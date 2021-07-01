package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class TweetDetailActivity extends AppCompatActivity {

    Tweet tweet;

    ImageView ivProfileImageDetails;
    TextView tvScreenNameDetails;
    TextView tvBodyDetails;
    TextView tvTimestampDetails;
    ImageView ivEmbeddedImageDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_detail);

        tvScreenNameDetails = findViewById(R.id.tvScreenNameDetails);
        tvBodyDetails = findViewById(R.id.tvBodyDetails);
        tvTimestampDetails = findViewById(R.id.tvTimestampDetails);
        ivProfileImageDetails = findViewById(R.id.ivProfileImageDetails);
        ivEmbeddedImageDetails = findViewById(R.id.ivEmbeddedImageDetails);

        tweet = Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));

        tvScreenNameDetails.setText(tweet.getUser().screenName);
        tvBodyDetails.setText(tweet.getBody());
        tvTimestampDetails.setText(tweet.getRelativeTimeAgo(tweet.createdAt));

        Glide.with(this).load(tweet.mediaURL).into(ivEmbeddedImageDetails);
        Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfileImageDetails);

    }
}