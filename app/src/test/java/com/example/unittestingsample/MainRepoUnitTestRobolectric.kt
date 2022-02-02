package com.example.unittestingsample

import android.content.Context
import com.example.unittestingsample.data.ResponseDTO
import com.example.unittestingsample.retrofit.RetrofitInterface
import com.example.unittestingsample.ui.MainRepo
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class, manifest = "src/main/AndroidManifest.xml")
class MainRepoUnitTestRobolectric {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @ApplicationContext
    lateinit var context: Context
    private lateinit var repo: MainRepo
    private lateinit var mockInterface: RetrofitInterface


    @Before
    fun init() {
        hiltRule.inject()
        mockInterface = Mockito.mock(RetrofitInterface::class.java)
        repo = MainRepo(mockInterface, context)
    }

    @Test
    fun example() {
        Assert.assertEquals(4, 2 + 2)
    }

    @Test
    fun testFetchDataReturnsString() {
        runBlocking {
            Mockito.`when`(mockInterface.getData()).thenReturn(ResponseDTO("whats up"))
            val result = repo.fetchData()
            Assert.assertEquals(result, "whats up")
        }
    }
}