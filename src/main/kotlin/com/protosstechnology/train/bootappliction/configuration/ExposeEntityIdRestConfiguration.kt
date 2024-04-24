package com.protosstechnology.train.bootappliction.configuration

import com.protosstechnology.train.bootappliction.entity.User
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration // tell compiler this file is configuration file
open class ExposeEntityIdRestConfiguration : RepositoryRestConfigurer {
    @Override
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry?) {
        config!!.exposeIdsFor(User::class.java)
    }
}