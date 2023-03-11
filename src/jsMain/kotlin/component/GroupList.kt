package component

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import com.sovostyanov.application.config.Config
import tanstack.query.core.QueryKey
import tanstack.react.query.useQuery
import tools.fetchText


external interface GroupListProps : Props {
    var groups: Array<String>
}

val CGroupList = FC<GroupListProps>("GroupList") { props ->
    ol {
        props.groups.forEach { group ->
            li {
                CGroupItem {
                    this.group = group
                }
            }
        }
    }
}

val containerGroupList = FC<Props>("QueryGroupList") {
    val query = useQuery<String, QueryError, String, QueryKey>(
        queryKey = arrayOf("groupsList").unsafeCast<QueryKey>(),
        queryFn = {
            fetchText(Config.groupsPath)
        }
    )

    if (query.isLoading) div { +"Loading .." }
    else if (query.isError) div { +"Error!" }
    else {
        val data = query.data ?: ""
        val items = Json{ ignoreUnknownKeys = true }.decodeFromString<Array<String>>(data)

        CGroupList {
            groups = items
        }
    }
}