import React, { Component } from "react";
import done from './icons/Done.png';
import trash from './icons/Trash.png';
import edit from './icons/Edit.png';

export default class App extends Component {
    state = {
        data: [
        ],
        value: "",
        price: 0,
        total: 0,
        msg: "",
        msgClassName: "", // 메시지의 CSS 클래스
        isSubmitButton: true, // 제출 버튼 상태
        editingId: null, // 편집중인 아이템 ID
    };

    valueChange = (e) => {
        this.setState({ value: e.target.value });
    }

    priceChange = (e) => {
        this.setState({ price: e.target.value });
    }

    handleSubmit = (e) => {
        e.preventDefault();
        if (this.state.isSubmitButton) {
            const newTotal = this.state.total + Number(this.state.price);
            const newPlan = {
                id: Date.now(),
                value: this.state.value || "no",
                price: Number(this.state.price),
            };

            this.setState({
                data: [...this.state.data, newPlan],
                total: newTotal,
                value: "",
                price: 0,
                msg: "아이템이 생성되었습니다.",
                msgClassName: "create msg" // 초록색 메시지 클래스
            });
        } else {
            this.addUpdate(this.state.editingId);
        }
    }

    allDelete = () => {
        this.setState({
            data: [],
            total: 0,
            msg: "전부 삭제 되었습니다.",
            msgClassName: "red msg" // 빨간색 메시지 클래스
        });
    }

    delete = (id) => {
        let newData = this.state.data.filter(data => data.id !== id);
        let newTotal = this.state.data.find(item => item.id === id) ? this.state.total - this.state.data.find(item => item.id === id).price : this.state.total;

        this.setState({
            data: newData,
            total: newTotal,
            msg: "삭제 되었습니다.",
            msgClassName: "red msg" // 빨간색 메시지 클래스
        });
    }

    addUpdate = (id) => {
        this.setState(prevState => ({
            data: prevState.data.map(item =>
                item.id === id ? { ...item, value: this.state.value, price: this.state.price } : item
            )
        }), () => {
            let newTotal = this.state.data.reduce((sum, item) => sum + Number(item.price), 0);
            this.setState({
                value: "",
                price: "",
                total: newTotal,
                isSubmitButton: true, // 버튼을 제출 상태로 변경
                editingId: null, // 편집 중인 ID 초기화
                msg: "수정 되었습니다",
                msgClassName: "create msg"
            });
        });
    }

    update = (id) => {
        let plan = this.state.data.find(item => item.id === id);

        if (plan) {
            this.setState({
                value: plan.value,
                price: plan.price,
                isSubmitButton: false, // 버튼을 수정 상태로 변경
                editingId: id, // 현재 편집 중인 아이템의 ID 설정

                msg: "",
                msgClassName: ""
            });
        }
    }

    render() {
        return (
            <div className="container">
                <div className="todoBlock">
                    <div className="title">
                        <div className={`msg ${this.state.msgClassName}`}>{this.state.msg}</div>
                        <h1>예산 계산기</h1>
                    </div>
                    <div className="whiteContainer">
                        <form onSubmit={this.handleSubmit} className="whiteFrom">
                            <div className="inputCon">
                                <div className="inputContent">
                                    <p>지출 항목</p>
                                    <input type="text"
                                        name="value"
                                        className="inputIndex "
                                        placeholder="예)렌트비"
                                        value={this.state.value}
                                        onChange={this.valueChange} />
                                </div>
                                <div className="inputContent">
                                    <p>비용</p>
                                    <input type="number"
                                        name="price"
                                        className="inputIndex "
                                        value={this.state.price}
                                        onChange={this.priceChange} />
                                </div>
                            </div>
                            <button
                                type="submit"
                                className="btnStyle image-button submitBtn"
                                style={{ flex: '1' }}
                            >
                                <span>{this.state.isSubmitButton ? '제출' : '수정'}</span>
                                <img src={done} className='imaSize15' alt="Done" />
                            </button>
                            {this.state.data.map((map) => (
                                <div key={map.id}>
                                    <div className='itemBox'>
                                        <div className='valueCon'>{map.value}</div>
                                        <div className='priceCon'>{map.price}
                                            <div className='iconCon'>
                                                <img className='imaSize16 imgGreen' onClick={() => this.update(map.id)} src={edit} alt="edit" />
                                                <img className='imaSize16 imgRed' alt="trash" onClick={() => this.delete(map.id)} src={trash} />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            ))}
                            <br/>
                            <button
                                type="button"
                                className="btnStyle image-button"
                                style={{ flex: '1' }}
                                onClick={this.allDelete}
                            >
                                목록 지우기 <img src={trash} className='imaSize15' alt="Trash" />
                            </button>
                        </form>
                    </div>
                    <div><h2>총지출 : {this.state.total}원</h2></div>
                </div>
            </div>
        )
    }
}