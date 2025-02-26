const SectionDetail = () => {
    return (
        <div className="card section p-3">
            <div className="card-body">
                <div className="d-flex align-items-center">
                    
                    <div className="flex-shrink-0 me-3 start-0">
                        <img 
                            src="https://icons.veryicon.com/png/o/miscellaneous/eva-icon-fill/list-47.png" 
                            alt="Icon"
                            className="rounded-circle"
                            style={{ width: "40px", height: "40px" }}
                        />
                    </div>

                    <div className="flex-grow-1 text-start content-text-section">
                        <p class="lead fw-normal mb-2">Thông báo nghỉ học</p>
                        <p><span class="text-muted">Thông báo: </span>Nghỉ học chiều hôm nay, thầy đi đánh bida 
                        <br/><span class="text-muted">Không bù: </span>Alo</p>
                    </div>


                    <div className="flex-shrink-0 end-0">
                        <button className="btn btn-primary">Mark as done</button>
                    </div>

                </div>
            </div>
        </div>
    );
};
export default SectionDetail;
