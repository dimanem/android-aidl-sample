package com.dima.sample.aidl.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.dima.sample.aidl.IStringGenerator;

import java.util.UUID;

public class MyService extends Service {

    private IStringGenerator.Stub stringGenerator = new StringGeneratorImpl();

    @Override
    public IBinder onBind(Intent intent) {
        return stringGenerator;
    }

    private class StringGeneratorImpl extends IStringGenerator.Stub {
        @Override
        public String generateString(int length) throws RemoteException {
            return UUID.randomUUID().toString().substring(0, 6);
        }
    }
}
