import SectionComponent from "../../../components/ClassRoom/ClassDetail/Section"
import TeacherInfo from "../../../components/ClassRoom/TeacherInfo"
import ClassInfo from "../../../components/ClassRoom/ClassInfo"
import NavBarComponent from "../../../components/ClassRoom/ClassDetail/NavBar"
import { useEffect, useState } from "react"
import { getClassDetail } from "../../../service/class/ClassRoomService"
import ClassCover from "../../../components/ClassRoom/ClassCover"
import ChevronBtn from "../../../components/button/ChevronBtn"

const ClassDetail = () => {


    const classId = "73967b27-28d7-46a1-a4ee-33eb09c6dc41"
    const [classDetail, setClassDetail] = useState();

    useEffect(() => {
        fetchClassDetail()
    }, []);

    const fetchClassDetail = async () => {
        let data = await getClassDetail(classId)
        
        if (data && data.code && data.code === 200 && data.result) {
            setClassDetail(data.result)
        }
    }

    console.log(classDetail?.sections)


    return <>

    <ClassCover name = {classDetail?.name}/>

    <div className="row">

        <div className="col-xl-8">
            <TeacherInfo teacher = {classDetail?.teacher}/>

            <div className="container-main card top-card">


            <div className="card text-center">
                <div className="card-header">
                    <NavBarComponent/>
                </div>
                <div className="card-body">

                    {
                        classDetail?.sections.map((section, index) => (
                            <div key={index}>
                                <SectionComponent index={index} section = {section} />
                            </div>
                        ))
                        
                    }
{/* 
                    <SectionComponent sections = {classDetail?.sections} /> */}
                </div>
            </div>
                

            </div>


        </div>


        <div className="col-xl-4">
            <ClassInfo detail = {classDetail?.detail} unit = {classDetail?.unit} tags = {classDetail?.tag} />
        </div>
    </div>
    
    
    </>
}

export default ClassDetail