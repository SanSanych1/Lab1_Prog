package component

import react.FC
import react.Props
import react.dom.html.ReactHTML.div

external interface GroupItemProps : Props {
    var group: String
}

val CGroupItem = FC<GroupItemProps>("GroupItem") { props ->
    div {
        props.group.let {
            +it
        }
    }
}