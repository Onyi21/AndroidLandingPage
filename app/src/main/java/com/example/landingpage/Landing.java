package com.example.landingpage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Landing extends AppCompatActivity {
    private TextView textViewResult;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        textViewResult = findViewById(R.id.landing_page_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        Call<List<Post>> call = jsonPlaceHolder.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()) {
                    textViewResult.setText("Code: "+ response.code());
                    return;
                }
                List<Post> posts = response.body();
                for(Post post: posts) {
                    String content = "";
                    content += "user id" + post.getUserId() + "\n";
                    content += "id"+ post.getId() + "\n";
                    content += "title"+ post.getTitle() + "\n";
                    content += "body" + post.getText() + "\n\n";
                    textViewResult.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}

