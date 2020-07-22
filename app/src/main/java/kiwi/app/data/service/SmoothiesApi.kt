package kiwi.app.data.service

import kiwi.app.model.Smoothie
import retrofit2.Response
import retrofit2.http.GET

interface SmoothiesApi {
    @GET("smoothies") suspend fun getSmoothies(): Response<List<Smoothie>>

    @GET("smoothie/{smoothie}") suspend fun getSmoothieByName(): Response<Smoothie>

    @GET("base/{base}") suspend fun getSmoothiesByBase(): Response<List<Smoothie>>

    @GET("ingredient/{ingredient}") suspend fun getSmoothiesByIngredient(): Response<List<Smoothie>>

    /** OTHER EXAMPLES:
     * @POST("parts") fun addPartAsync(@Body newPart : PartData): Deferred<Response<Void>>
     * @DELETE("parts/{id}") fun deletePartAsync(@Path("id") id: Long) : Deferred<Response<Void>>
     * @PUT("parts/{id}") fun updatePartAsync(@Path("id") id: Long, @Body newPart: PartData) : Deferred<Response<Void>>
    }*/
}