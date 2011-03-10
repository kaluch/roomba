close all;
capteurs_define;
figure(1);
plot(X(:,1),X(:,2));
figure(2);
plot(Y(:,1),Y(:,2),'r');
figure(3)
plot(Z(:,1),Z(:,2),'g');
figure(4)
plot(W(:,1),W(:,2),'y');
figure(5);
plot(V(:,1),V(:,2),'c');
figure(6);
plot(pos(:,1),pos(:,2));

figure(7);
hold on;
plot(pos(:,1),pos(:,2),'k');
plot(X(:,1),X(:,2));
plot(Y(:,1),Y(:,2),'r');
plot(Z(:,1),Z(:,2),'g');
plot(W(:,1),W(:,2),'y');
plot(V(:,1),V(:,2),'c');
