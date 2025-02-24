import { Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import { FaGem, FaHeart } from 'react-icons/fa';
import { Outlet } from 'react-router-dom';

const Teacher = () => {
    return (
        <div className='class-list-content row full-width'>

            <div className='side-bar col-2'>
            <Sidebar backgroundColor="white">
            <Menu>
                <SubMenu label="Class Management" icon={<FaGem />}>
                <MenuItem> Add Class </MenuItem>
                <MenuItem> Class List </MenuItem>
                </SubMenu>
                <MenuItem> Documentation </MenuItem>
                <MenuItem> Calendar </MenuItem>
            </Menu>
            
            </Sidebar>;

            </div>

            <div className='main-content col-10'>
                <Outlet/>
            </div>
            
        </div>
    );
}

export default Teacher;
