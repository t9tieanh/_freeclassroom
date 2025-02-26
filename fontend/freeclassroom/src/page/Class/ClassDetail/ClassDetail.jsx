import SectionComponent from "../../../components/ClassRoom/ClassDetail/Section"
import TeacherInfo from "../../../components/ClassRoom/TeacherInfo"
import ClassInfo from "../../../components/ClassRoom/ClassInfo"
import NavBarComponent from "../../../components/ClassRoom/ClassDetail/NavBar"

const ClassDetail = () => {
    return <>


    <div className="row">

        <div className="col-xl-8">

            
            <TeacherInfo/>

            <div className="container-main card top-card">


            <div className="card text-center">
                <div className="card-header">
                    <NavBarComponent/>
                </div>
                <div className="card-body">
                    <SectionComponent/>
                </div>
            </div>
                
                


            </div>


        </div>


        <div className="col-xl-4">
            <ClassInfo/>
        </div>
    </div>
    
    
    </>
}

export default ClassDetail