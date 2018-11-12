package lt.neworld.rust

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_compute.setOnClickListener {
            val input = view_input.text.toString()
            val digest = md5(input)
            view_output.text = digest
        }
    }

    companion object {

        @JvmStatic
        external fun md5(input: String): String

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("rust")
        }
    }
}
