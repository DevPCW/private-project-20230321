window.onload = () => {
    IndexButtonService.getInstance().loginButtonOnclickEvent();
}

class IndexButtonService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new IndexButtonService();
        }
        return this.#instance;
    }

    loginButtonOnclickEvent() {
        const infoLoginButton = document.querySelectorAll('.info-container-nav')[0];

        infoLoginButton.onclick = () => {
            location.href = '/account/login';
        }
    }
}