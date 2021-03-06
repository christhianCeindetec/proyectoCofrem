package com.cofrem.transacciones.SplashScreen;

import android.content.Context;

import com.cofrem.transacciones.SplashScreen.events.SplashScreenEvent;
import com.cofrem.transacciones.SplashScreen.ui.SplashScreenView;
import com.cofrem.transacciones.lib.EventBus;
import com.cofrem.transacciones.lib.GreenRobotEventBus;

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    /**
     * #############################################################################################
     * Declaracion de componentes y variables
     * #############################################################################################
     */
    //Declaracion del bus de eventos
    EventBus eventBus;

    /**
     * #############################################################################################
     * Instanciamientos de las clases
     * #############################################################################################
     */
    //Instanciamiento de la interface SplashScreenView
    private SplashScreenView splashScreenView;

    //Instanciamiento de la interface SplashScreenInteractor
    private SplashScreenInteractor splashScreenInteractor;

    /**
     * #############################################################################################
     * Constructor de la clase
     * #############################################################################################
     *
     * @param splashScreenView
     */
    public SplashScreenPresenterImpl(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
        this.splashScreenInteractor = new SplashScreenInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    /**
     * #############################################################################################
     * Metodos sobrecargados de la interface
     * #############################################################################################
     */

    /**
     * Sobrecarga del metodo onCreate de la interface SplashScreenPresenter "crear" el registro al bus de eventos
     */
    @Override
    public void onCreate() {

        eventBus.register(this);

    }

    /**
     * Sobrecarga del metodo onDestroy de la interface SplashScreenPresenter para "eliminar"  el registro al bus de eventos
     */
    @Override
    public void onDestroy() {
        splashScreenView = null;
        eventBus.unregister(this);
    }

    /**
     * Metodo para la verificacion de los datos
     */
    @Override
    public void validateAccess(Context context) {
        if (splashScreenView != null) {
            splashScreenView.showProgress();
            splashScreenInteractor.validateAccess(context);
        }
    }

    /**
     * Sobrecarga del metodo onEventMainThread de la interface SplashScreenPresenter para el manejo de eventos
     *
     * @param splashScreenEvent
     */
    @Override
    public void onEventMainThread(SplashScreenEvent splashScreenEvent) {
        switch (splashScreenEvent.getEventType()) {

            case SplashScreenEvent.onVerifySuccess:
                onVerifySuccess();
                break;

            case SplashScreenEvent.onVerifyError:
                onVerifyError();
                break;

            case SplashScreenEvent.onInternetConnectionSuccess:
                onInternetConnectionSuccess();
                break;

            case SplashScreenEvent.onInternetConnectionError:
                onInternetConnectionError();
                break;

            case SplashScreenEvent.onMagneticReaderDeviceSuccess:
                onMagneticReaderDeviceSuccess();
                break;

            case SplashScreenEvent.onMagneticReaderDeviceError:
                onMagneticReaderDeviceError();
                break;

            case SplashScreenEvent.onNFCDeviceSuccess:
                onNFCDeviceSuccess();
                break;

            case SplashScreenEvent.onNFCDeviceError:
                onNFCDeviceError();
                break;

            case SplashScreenEvent.onPrinterDeviceSuccess:
                onPrinterDeviceSuccess();
                break;

            case SplashScreenEvent.onPrinterDeviceError:
                onPrinterDeviceError();
                break;

        }
    }

    /**
     * #############################################################################################
     * Metodo propios de la clase
     * #############################################################################################
     */

    /**
     * Metodo para manejar la verificacion exitosa
     */
    private void onVerifySuccess() {
        if (splashScreenView != null) {
            splashScreenView.handleVerifySuccess();
        }
    }

    /**
     * Metodo para manejar la verificacion erronea
     */
    private void onVerifyError() {
        if (splashScreenView != null) {
            splashScreenView.handleVerifyError();
        }
    }

    /**
     * Metodo para manejar la conexion a internet exitosa
     */
    private void onInternetConnectionSuccess() {
        if (splashScreenView != null) {
            splashScreenView.handleInternetConnectionSuccess();
        }
    }

    /**
     * Metodo para manejar la conexion a internet erronea
     */
    private void onInternetConnectionError() {
        if (splashScreenView != null) {
            splashScreenView.handleInternetConnectionError();
        }
    }

    /**
     * Metodo para manejar la conexion al dispositivo lector de banda magnetica exitosa
     */
    private void onMagneticReaderDeviceSuccess() {
        if (splashScreenView != null) {
            splashScreenView.handleMagneticReaderDeviceSuccess();
        }
    }

    /**
     * Metodo para manejar la conexion al dispositivo lector de banda magnetica erronea
     */
    private void onMagneticReaderDeviceError() {
        if (splashScreenView != null) {
            splashScreenView.handleMagneticReaderDeviceError();
        }
    }

    /**
     * Metodo para manejar la conexion al dispositivo NFC exitosa
     */
    private void onNFCDeviceSuccess() {
        if (splashScreenView != null) {
            splashScreenView.handleNFCDeviceSuccess();
        }
    }

    /**
     * Metodo para manejar la conexion al dispositivo NFC erronea
     */
    private void onNFCDeviceError() {
        if (splashScreenView != null) {
            splashScreenView.handleNFCDeviceError();
        }
    }

    /**
     * Metodo para manejar la conexion al dispositivo de impresion exitosa
     */
    private void onPrinterDeviceSuccess() {
        if (splashScreenView != null) {
            splashScreenView.handlePrinterDeviceSuccess();
        }
    }

    /**
     * Metodo para manejar la conexion al dispositivo de impresion erronea
     */
    private void onPrinterDeviceError() {
        if (splashScreenView != null) {
            splashScreenView.handlePrinterDeviceError();
        }
    }
}
