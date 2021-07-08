package mike.sample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.mike.sample.ILogin
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = "/activit/main")
class MainActivity : AppCompatActivity(), MainContract.View {
    companion object {
        const val TAG = "MainActivity"
    }

    lateinit var mainPresenter: MainContract.Presenter

    var login: ILogin? = null

    private val  mName =  NameLiveData()


    @Autowired
    lateinit var login2: ILogin

    override fun onCreate(savedInstanceState: Bundle?) {
        mName.observe()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ltRoot.setOnTouchListener { v, event ->
//            Log.e(TAG, "onTouch, 1111=")
//            true
//        }

        ARouter.init(this.application)

        login = ARouter.getInstance().navigation(ILogin::class.java)
        login = ARouter.getInstance().build("/login/main").navigation() as ILogin?
        if (login == null) {
            Log.e("czm", "null")
        }
        login?.login("czm", "czm")
//        ARouter.getInstance().inject(this)
//        login2.login("czm22", "czm22")
//        LoginImpl
//        Log.i(TAG, "device: ${Build.DEVICE}")
//        Log.i(TAG, "product: ${Build.PRODUCT}")
//        Log.i(TAG, DisplayUtil.dumpDisplayInfo(this))
//+
//        Log.e(TAG, "onCreate, mainPresenter = $mainPresenter")
//        mainPresenter.start(this)
//
//        val aboutFragment = AboutFragment()
//
//        tvMsg.setOnClickListener {
//
//            val ft = supportFragmentManager.beginTransaction()
//            if (!aboutFragment.isAdded) {
//                ft.add(R.id.system1stLevelMenu, aboutFragment)
//            } else {
//                ft.show(aboutFragment)
//            }
//            ft.commitNow()
//
////            val intent = Intent()
////            intent.action = "android.intent.action.VIEW"
//////            val uri: Uri = Uri.parse("https://www.remote-manage.com/license")
////            val uri: Uri = Uri.parse("https://chengzhang.lizhitalk.com/blog/neutral-android-w/")
////            intent.data = uri
////            startActivity(intent)
//        }

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        Log.e(TAG, "onWindowFocusChanged")
    }

    override fun start(presenter: MainContract.Presenter) {
        // nop
    }

    override fun asView(): View {
        return ltRoot
    }
}