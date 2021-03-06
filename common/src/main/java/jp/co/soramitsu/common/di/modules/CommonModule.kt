package jp.co.soramitsu.common.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import jp.co.soramitsu.common.di.scope.ApplicationScope
import jp.co.soramitsu.common.resources.ResourceManagerImpl
import jp.co.soramitsu.core.ResourceManager

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManagerImpl(context)
    }
}