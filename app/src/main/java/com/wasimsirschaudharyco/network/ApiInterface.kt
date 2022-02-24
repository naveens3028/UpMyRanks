package com.wasimsirschaudharyco.network

import com.wasimsirschaudharyco.model.*
import com.wasimsirschaudharyco.model.assignment.AssignmentModel
import com.wasimsirschaudharyco.model.assignment.AssignmentResponse
import com.wasimsirschaudharyco.model.live.Batch
import com.wasimsirschaudharyco.model.onBoarding.CompletedSession
import com.wasimsirschaudharyco.model.publish.PublishMaterialResponse
import okhttp3.RequestBody
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*
import okhttp3.MultipartBody
import retrofit2.Call

import retrofit2.http.POST

import retrofit2.http.Multipart
import retrofit2.http.PartMap


interface ApiInterface {

    @POST("session/getCompletedSessionsSubject")
    suspend fun getData(@Body jsonObject: JSONObject , @HeaderMap hashMap: HashMap<String, String>): Response<List<CompletedSession>>

    @GET("assignment/getAssignment/{batchId}")
    suspend fun getAssignments(@Path("batchId")  url: String, @HeaderMap hashMap: HashMap<String, String>): Response<List<AssignmentModel>>

    @Multipart
    @POST("assignment/addAssignment")
    fun postAssignment(
        @PartMap partMap: java.util.HashMap<String, RequestBody>,
        @Part file: MultipartBody.Part?
    ): Call<AssignmentResponse>

    @GET("course/child/{courseId}")
    suspend fun getCourseSubject(@Path("courseId")  url: String, @HeaderMap hashMap: HashMap<String, String>): Response<CourseSubjectResponse>

    @GET("course/child/{subjectId}")
    suspend fun getSubjectChapter(@Path("subjectId")  url: String, @HeaderMap hashMap: HashMap<String, String>): Response<CourseSubjectResponse>

    @GET("course/child/{chapterId}")
    suspend fun getChapterTopics(@Path("chapterId")  url: String, @HeaderMap hashMap: HashMap<String, String>): Response<CourseSubjectResponse>

    @GET("course/allCoursesByCoaching")
    suspend fun getCoursesByCoachingCenter(@Query("coachingCentreId") coachingCentreId: String, @HeaderMap hashMap: HashMap<String, String>): Response<List<Datum>>

    @GET("coachingCentreBranch/branchesForCourse")
    suspend fun getBranchesForCourse(@Query("coachingCentreId") coachingCentreId: String,@Query("courseId") courseId: String, @HeaderMap hashMap: HashMap<String, String>): Response<List<Branch>>

    @GET("batch/batchesByCourse")
    suspend fun getBatchesByCourse(@QueryMap options: Map<String, String>, @HeaderMap hashMap: HashMap<String, String>): Response<List<Batch>>

    @GET("material/unPublishedMaterials")
    suspend fun getMaterial(@QueryMap options: Map<String, String>, @HeaderMap hashMap: HashMap<String, String>): Response<List<Material>>


    @POST("materialAccess/save")
    suspend fun publishMaterials(@Body jsonObject: JsonObject , @HeaderMap hashMap: HashMap<String, String>): Response<PublishMaterialResponse>

}