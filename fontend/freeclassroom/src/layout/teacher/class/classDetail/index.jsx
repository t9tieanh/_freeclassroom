
import { Outlet } from 'react-router-dom';
import SideBar from '../../../../components/Teacher/SideBar';
import ClassCover from '../../../../components/ClassRoom/ClassCover';

const ClassLayout = () => {
    return (
        <div className='class-list-content row full-width'>

            <div className='side-bar col-2'>
                <SideBar/>
            </div>

            <div className='main-content col-10'>
                <ClassCover/>
                <Outlet/>
            </div>
            
        </div>
    );
}

export default ClassLayout