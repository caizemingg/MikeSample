package mike.sample

import androidx.lifecycle.LiveData

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2021/5/9
 * @description:
 */
class NameLiveData : LiveData<String>() {

    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }

}