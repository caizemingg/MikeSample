package mike.sample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.layout_about.*
import javax.inject.Inject

/**
 * author: WentaoKing
 * created on: 2019-09-29
 * description: 关于页面
 */
@AndroidEntryPoint
class AboutFragment : Fragment() {

    companion object WebViewConstant {
        const val TAG = "AboutFragment"
        private const val OPEN_WEB_VIEW_ACTION = "android.intent.action.VIEW"
    }

    @Inject
    lateinit var mainPresenter: MainContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "onCreateView, mainPresenter = $mainPresenter")
        return inflater.inflate(R.layout.layout_about, null)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated, mainPresenter = $mainPresenter")

        tvMsg.setOnClickListener {
            showOpenSourceLicensesWebView()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "onAttach, mainPresenter = $mainPresenter")
    }

    /**
     * 打开开源许可证网页
     */
    private fun showOpenSourceLicensesWebView() {
//        val intent = Intent()
//        intent.action = WebViewConstant.OPEN_WEB_VIEW_ACTION
//        val openSourceLicensesUrl = Uri.parse(CustomerConfig.URL_OPEN_SOURCE_LICENSES)
//        intent.data = openSourceLicensesUrl
//        startActivity(intent)

        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
//            val uri: Uri = Uri.parse("https://www.remote-manage.com/license")
        val uri: Uri = Uri.parse("https://chengzhang.lizhitalk.com/blog/neutral-android-w/")
        intent.data = uri
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}