package component

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import com.sovostyanov.application.config.Config
import com.sovostyanov.application.data.MenuItem
import csstype.string
import react.router.dom.Link
import tanstack.query.core.QueryKey
import tanstack.react.query.useQuery
import tools.fetchText


external interface MenuProps : Props {
    var menuElements: Array<MenuItem>
}

val CMenuList = FC<MenuProps>("Menu") { props ->
    ol {
        props.menuElements.forEach { element ->
            li {
                Link{
                    +element.displayName
                    to = element.path
                }
            }
        }
    }
}

val containerMenuList = FC<Props>("QueryGroupList") {
    val query = useQuery<String, QueryError, String, QueryKey>(
        queryKey = arrayOf("menuList").unsafeCast<QueryKey>(),
        queryFn = {
            fetchText("menu/")
        }
    )

    if (query.isLoading) div { +"Loading .." }
    else if (query.isError) div { +"Error!" }
    else {
        val data = query.data ?: ""
        val items = Json{ ignoreUnknownKeys = true }.decodeFromString<Array<MenuItem>>(data)

        CMenuList {
            menuElements = items
        }
    }
}