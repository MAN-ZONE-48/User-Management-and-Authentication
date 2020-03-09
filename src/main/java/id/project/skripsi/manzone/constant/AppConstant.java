package id.project.skripsi.manzone.constant;

public enum AppConstant {
    FAIIED("FAILED"),SUCCESS("SUCCESS");

    private String message;

    AppConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
