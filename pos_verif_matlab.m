close all;
capteurs_define;
% figure(1);
% plot(X(:,2),X(:,1));
% figure(2);
% plot(Y(:,2),Y(:,1),'r');
% figure(3)
% plot(Z(:,2),Z(:,1),'g');
% figure(4)
% plot(W(:,2),W(:,1),'y');
% figure(5);
% plot(V(:,2),V(:,1),'c');
% figure(6);
% plot(pos(:,2),pos(:,1));

figure(7);
axis([-1 1 -1 1]);
hold on;
for i=1:length(X)
    plot(pos(1:i,2),pos(1:i,1),'k');
    plot(X(1:i,2),X(1:i,1));
    plot(Y(1:i,2),Y(1:i,1),'r');
    plot(Z(1:i,2),Z(1:i,1),'g');
    plot(W(1:i,2),W(1:i,1),'m');
    %plot(V(1:i,2),V(1:i,1),'c');
    pause(0.1);
end
