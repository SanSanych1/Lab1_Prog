import com.sovostyanov.application.data.Student
import component.*
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.router.Route
import react.router.Routes
import react.router.dom.HashRouter
import tanstack.query.core.QueryClient
import tanstack.react.query.QueryClientProvider
import web.dom.document

val queryClient = QueryClient()

fun main() {
    val container = document.getElementById("root")!!
    createRoot(container).render(app.create())
}

val app = FC<Props> ("App"){
    HashRouter{
        QueryClientProvider {
            client = queryClient
            containerMenuList{}
            Routes{
                Route{
                    path = "students/"
                    element = containerStudentList.create{}
                }
                Route{
                    path = "groups/"
                    element = containerGroupList.create{}
                }
            }
//            containerStudentList {}
//            containerGroupList{}
        }

    }

}