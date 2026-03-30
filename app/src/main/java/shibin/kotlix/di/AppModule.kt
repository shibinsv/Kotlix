package shibin.kotlix.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.shibin.feature_flow.repository.FlowOperatorRepository
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFlowOperatorRepository(): FlowOperatorRepository =
        FlowOperatorRepository()
}