package mike.sample

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * @author caizeming
 * @email  caizeming@cvte.com
 * @date   2020/9/12
 * @description:
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindMainPresenter(mainPresenter: MainPresenter): MainContract.Presenter
}