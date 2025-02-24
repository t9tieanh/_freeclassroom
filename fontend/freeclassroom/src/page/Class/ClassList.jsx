import './ClassList.scss'
import { Sidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import { FaGem, FaHeart } from 'react-icons/fa';
import Paginate from '../../components/paging/Paginate';
import { CiSearch } from "react-icons/ci";

const ClassList = () => {
    return (
        <>
        
        <div className="row title">
                    <div className="col-lg-11 mx-auto mb-4">
                        <div className="section-title text-center">
                        <h3 className='font-weight-bold'>
                        YOUR CLASS
                        <small class="text-muted font-weight-bold">@freeclassroom
                            _phamtienanh</small>
                        </h3>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-lg-10 mx-auto">
                        <div className="career-search mb-60">
                            <form className="career-form mb-60">
                                <div className="row">
                                    <div className="col-md-6 col-lg-3">
                                        <input type="text" className="form-control" placeholder="Enter Your Keywords" id="keywords" />
                                    </div>
                                    <div className="col-md-6 col-lg-3">
                                        <select className="custom-select">
                                            <option selected>Location</option>
                                            <option value="1">Jaipur</option>
                                            <option value="2">Pune</option>
                                            <option value="3">Bangalore</option>
                                        </select>
                                    </div>
                                    <div className="col-md-6 col-lg-3">
                                        <select className="custom-select">
                                            <option selected>Select Class Type</option>
                                            <option value="1">UI Designer</option>
                                            <option value="2">JS Developer</option>
                                            <option value="3">Web Developer</option>
                                        </select>
                                    </div>
                                    <div className="col-md-6 col-lg-3 ">
                                        <button type="button" className=" btn btn-block btn-primary "><i class="fa-solid fa-magnifying-glass"></i>&nbsp; Search</button>
                                    </div>
                                </div>
                            </form>
                            <div className="filter-result">
                                <p className="mb-30 ff-montserrat totalcount"><i class="fa-solid fa-filter"></i>&nbsp;Total Class : 89</p>
                                {[
                                    { title: "Front End Developer", location: "Los Angeles", salary: "2500-3500/pm", type: "Full Time", initials: "FD" },
                                    { title: "UI/UX Developer", location: "Los Angeles", salary: "2500-3500/pm", type: "Full Time", initials: "UX" },
                                    { title: "Graphic Designer", location: "Los Angeles", salary: "2500-3500/pm", type: "Full Time", initials: "GD" }
                                ].map((job, index) => (
                                    <div key={index} className="job-box d-md-flex align-items-center justify-content-between mb-30 hover-shadow">
                                        <div className="job-left my-4 d-md-flex align-items-center flex-wrap">
                                            <div className="img-holder mr-md-4 mb-md-0 mb-4 mx-auto mx-md-0 d-md-none d-lg-flex">
                                            <img width={"120px"}
                                            src="https://mdbcdn.b-cdn.net/img/new/standard/city/047.webp"
                                            alt="Townhouses and Skyscrapers"
                                            />
                                                {/* {job.initials} */}
                                            </div>
                                            <div className="job-content">
                                                <h5 className="text-center text-md-left">{job.title}</h5>
                                                <ul className="d-md-flex flex-wrap text-capitalize ff-open-sans">
                                                    <li className="mr-md-4"><i className="zmdi zmdi-pin mr-2"></i> {job.location}</li>
                                                    <li className="mr-md-4"><i className="zmdi zmdi-money mr-2"></i> {job.salary}</li>
                                                    <li className="mr-md-4"><i className="zmdi zmdi-time mr-2"></i> {job.type}</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div className="job-right my-4 flex-shrink-0">
                                            <button className="btn d-block w-100 d-sm-inline-block btn-primary">Detail &nbsp;<i class="fa-solid fa-circle-info"></i></button>
                                        </div>
                                    </div>
                                ))}
                            </div>
                        </div>
                        <nav className='paginate-container' aria-label="Page navigation">
                            <Paginate  itemsPerPage = {3} pageCount = {3} currentPage = {2}/>
                        </nav>
                    </div>
                </div>
        
        
        </>
    );
}

export default ClassList;
