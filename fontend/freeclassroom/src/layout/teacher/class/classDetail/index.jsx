import { Outlet } from "react-router-dom";
import ClassCover from "../../../../components/ClassRoom/ClassCover";
import "./style.scss";
import SideBar from '../../../../components/Teacher/SideBar';

const ClassDetailLayout = () => {
  return (
    <>

<div className='class-list-content row full-width'>
    
    <div className='side-bar col-2'>
        <SideBar/>
    </div>

        <div className='main-content col-10'>
          <div className="class-detail-content">
            <Outlet/>
          </div>
        </div>
        
    </div>

    </>



  );
};

export default ClassDetailLayout;
