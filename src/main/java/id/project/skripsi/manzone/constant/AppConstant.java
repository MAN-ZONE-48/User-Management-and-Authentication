package id.project.skripsi.manzone.constant;

public enum AppConstant {
    FAILED("FAILED"),SUCCESS("SUCCESS");

    private String message;

    AppConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
