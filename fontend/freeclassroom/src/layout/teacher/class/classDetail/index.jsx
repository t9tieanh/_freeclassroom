import { Outlet } from "react-router-dom";
import ClassCover from "../../../../components/ClassRoom/ClassCover";
import "./style.scss";

const ClassDetailLayout = () => {
  return (
    <>
    <div className="class-detail-content">

    <ClassCover/>
    <Outlet/>

    {/* <div className="row">

        <div className="col-xl-8">

            
            <TeacherInfo/>

            <div className="container-main card top-card">
                <Outlet/>
            </div>


        </div>


        <div className="col-xl-4">
            <ClassInfo/>
        </div>
    </div> */}
    </div>

    </>



  );
};

export default ClassDetailLayout;
