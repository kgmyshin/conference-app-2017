package io.github.droidkaigi.confsched2017.util

import android.os.Build
import org.junit.Assert.assertNotNull
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.lang.reflect.InvocationTargetException
import java.util.*

/**
 * Created by KeishinYokomaku on 2017/01/17.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = intArrayOf(Build.VERSION_CODES.JELLY_BEAN_MR1, Build.VERSION_CODES.JELLY_BEAN_MR2))
class DateUtilTest {
    @Test
    @Throws(Exception::class)
    fun ctor() {
        // no instance allowed even if creating a new instance via reflection
        // because this is an utility!
        try {
            val ctor = DateUtil::class.java.getDeclaredConstructor()
            ctor.isAccessible = true
            ctor.newInstance()
        } catch (e: InvocationTargetException) {
            if (e.cause !is AssertionError)
                fail()
        }
    }

    @Test
    @Throws(Exception::class)
    fun getMonthDate_nonNull() {
        val month = DateUtil.getMonthDate(Date(System.currentTimeMillis()), RuntimeEnvironment.application)
        assertNotNull(month)
    }
}
