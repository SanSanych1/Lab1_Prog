package component

import com.sovostyanov.application.data.Student
import react.FC
import react.Props
import react.dom.html.ReactHTML.div

external interface StudentItemProps : Props {
    var student: Student
}

val CStudentItem = FC<StudentItemProps>("StudentItem") { props ->
    div {
        props.student.let {
            +"${it.firstname[0]}. ${it.surname} (${it.group})"
        }
    }
}