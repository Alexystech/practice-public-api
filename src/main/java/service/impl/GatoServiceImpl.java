package service.impl;

import com.google.gson.Gson;
import entity.GatoFav;
import io.vavr.control.Try;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import service.GatoService;
import entity.Gato;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class GatoServiceImpl implements GatoService {

    @Override
    public Gato getRandomGato() {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();

        AtomicReference<Gato> output = new AtomicReference<>(new Gato());

        Try.of( () -> {
            Response response = client.newCall(request).execute();
            String json = response.body().string();

            json = json.substring(1, json.length());
            json = json.substring(0, json.length() - 1);

            Gson gson = new Gson();
            Gato gato = gson.fromJson(json, Gato.class);
            output.set(gato);
            return 0;
        }).onFailure(Throwable::printStackTrace);

        return output.get();
    }

    @Override
    public List<GatoFav> getFavGatos() {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .method("GET", null)
                .addHeader("x-api-key", "77809408-7c7f-4100-8954-307d8980654e")
                .build();

        Try<GatoFav[]> gatosFav = Try.of( () -> {
            Response response = client.newCall(request).execute();
            String json = response.body().string();

            Gson gson = new Gson();
            GatoFav[] gatoFavs = gson.fromJson(json, GatoFav[].class);

            return gatoFavs;
        }).onFailure(Throwable::printStackTrace);

        return Arrays.stream(gatosFav.get()).collect(Collectors.toList());
    }

    @Override
    public void addToFavorites(String id_gato) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\": \""+ id_gato +"\"\r\n}");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "77809408-7c7f-4100-8954-307d8980654e")
                .build();

        Try.of( () -> client.newCall(request).execute() )
                .onFailure(Throwable::printStackTrace);

    }

    @Override
    public boolean deleteFavGato(String id_gato_fav) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites/" + id_gato_fav)
                .method("DELETE", body)
                .addHeader("x-api-key", "77809408-7c7f-4100-8954-307d8980654e")
                .build();

        Try<Boolean> success = Try.of( () -> {
            client.newCall(request).execute();
            return true;
        }).onFailure(Throwable::printStackTrace);

        return success.get();
    }

    @Override
    public GatoFav getGatoFavById(String id_gato_fav) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites/2105208")
                .method("GET", null)
                .addHeader("x-api-key", "77809408-7c7f-4100-8954-307d8980654e")
                .build();

        Try<GatoFav> gatoFavSelected = Try.of( () -> {
            Response response = client.newCall(request).execute();
            String json = response.body().string();

            Gson gson = new Gson();
            GatoFav gatoFav = gson.fromJson(json, GatoFav.class);

            return gatoFav;
        }).onFailure(Throwable::printStackTrace);

        return gatoFavSelected.get();
    }
}
