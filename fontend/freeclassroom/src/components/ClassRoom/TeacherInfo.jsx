import './TeacherInfo.scss'

const TeacherInfo = () => {
    return (
        <>
            <div className="card top-card">
                <div className="card-body pb-0">
                    <div className="row align-items-center">
                    <div className="col-md-3 teacher-avatar">
                        <div className="text-center border-end">
                        <img
                            src="http://moc247.com/wp-content/uploads/2023/10/suu-tam-50-anh-avatar-ngau-cho-nam-dep-buon-an-tuong-nhat_1.jpg"
                            className="img-fluid avatar-xxl rounded-circle"
                            alt="User Avatar"
                        />
                        <h4 className="text-primary font-size-20 mt-3 mb-2">
                            Jansh Wells
                        </h4>
                        <h5 className="text-muted font-size-13 mb-0">Web Designer</h5>
                        </div>
                    </div>
                    <div className="col-md-9">
                        <div className="ms-3">
                        <div>
                            <h4 className="card-title mb-2">Teacher</h4>
                            <p className="mb-0 text-muted">
                            Hi I'm Jansh, has been the industry's standard dummy text
                            To an English person alteration text.
                            </p>
                        </div>
                        <div className="row my-4">
                            <div className="col-md-12">
                            <div>
                                <p className="text-muted mb-2 fw-medium">
                                <i className="mdi mdi-email-outline me-2"></i>
                                <a href="mailto:example@example.com">
                                    example@example.com
                                </a>
                                </p>
                                <p className="text-muted fw-medium mb-0">
                                <i className="mdi mdi-phone-in-talk-outline me-2"></i>
                                418-955-4703
                                </p>
                            </div>
                            </div>
                        </div>
                        <ul
                            className="nav nav-tabs nav-tabs-custom border-bottom-0 mt-3 nav-justified"
                            role="tablist"
                        >
                            <li className="nav-item" role="presentation">
                            <a
                                className="nav-link px-4"
                                href="https://bootdey.com/snippets/view/profile-projects"
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                <span className="d-block d-sm-none">
                                <i className="fas fa-home"></i>
                                </span>
                                <span className="d-none d-sm-block">Projects</span>
                            </a>
                            </li>
                            <li className="nav-item" role="presentation">
                            <a
                                className="nav-link px-4"
                                href="https://bootdey.com/snippets/view/profile-task-with-team-cards"
                                target="_blank"
                                rel="noopener noreferrer"
                            >
                                <span className="d-block d-sm-none">
                                <i className="mdi mdi-menu-open"></i>
                                </span>
                                <span className="d-none d-sm-block">Tasks</span>
                            </a>
                            </li>
                            <li className="nav-item" role="presentation">
                            <a
                                className="nav-link px-4 active"
                                data-bs-toggle="tab"
                                href="#team-tab"
                                role="tab"
                                aria-selected="true"
                            >
                                <span className="d-block d-sm-none">
                                <i className="mdi mdi-account-group-outline"></i>
                                </span>
                                <span className="d-none d-sm-block">Team</span>
                            </a>
                            </li>
                        </ul>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default TeacherInfo