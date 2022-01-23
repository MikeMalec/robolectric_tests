package com.example.robolectric_test

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.testing.launchFragmentInContainer
import dagger.Module
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Singleton

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(
    manifest = Config.NONE,
    sdk = [Build.VERSION_CODES.O_MR1],
    application = HiltTestApplication::class
)
class SomeFragmentTest {
    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltAndroidRule.inject()
    }

    @Test
    fun someTest() {
        val frag = launchFragmentInHiltContainer<SomeFragment>()
    }
}


//@TestInstallIn(
//    replaces = [AppModule::class],
//    components = [SingletonComponent::class]
//)
//@Module
//object TestModule {
//    @Singleton
//    @Provides
//    fun provideSomeDependency(): SomeDependency {
//        return SomeDependency()
//    }
//}

@AndroidEntryPoint
class RoboTestActivity:AppCompatActivity()