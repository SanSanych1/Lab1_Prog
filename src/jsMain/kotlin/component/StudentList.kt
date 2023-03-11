package component

import com.sovostyanov.application.data.Student
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

external interface QueryError

external interface StudentListProps : Props {
    var students: Array<Student>
}

val CStudentList = FC<StudentListProps>("StudentList") { props ->
    ol {
        props.students.forEach { student ->
            li {
                CStudentItem {
                    this.student = student
                }
            }
        }
    }
}

val containerStudentList = FC<Props>("QueryStudentList") {
    val query = useQuery<String, QueryError, String, QueryKey>(
        queryKey = arrayOf("studentList").unsafeCast<QueryKey>(),
        queryFn = {
            fetchText(Config.studentsPath)
        }
    )

    if (query.isLoading) div { +"Loading .." }
    else if (query.isError) div { +"Error!" }
    else {
        val items = Json{ ignoreUnknownKeys = true }.decodeFromString<Array<Student>>(query.data ?: "")
        CStudentList {
            students = items
        }

    }
}
